// Add Detailed Student method
function addDetailedStudent() {
    const examNumber = $('#examNumber').val();
    const name = $('#name').val();
    const gender = $('#gender').val();
    const birthdate = $('#birthdate').val();
    const className = $('#className').val();
    const hometown = $('#hometown').val();
    const entranceScore = $('#entranceScore').val();

    const student = {
        examNumber: parseInt(examNumber),
        name: name,
        gender: gender,
        birthdate: birthdate,
        className: className,
        hometown: hometown,
        entranceScore: parseInt(entranceScore)
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8089/acstudents/students/addDetailed',
        contentType: 'application/json',
        data: JSON.stringify(student),
        success: function () {
            alert('学生添加成功！');
        },
        error: function (error) {
            console.error('添加学生时出错：', error);

            if (error.responseJSON && error.responseJSON.status === 500) {
                console.error('Server error:', error.responseJSON);
            }

            alert('添加学生时出错。有关详细信息，请查看控制台.');
        }
    });
}


function updateStudent() {
    const updateExamNumber = $('#updateExamNumber').val();
    const updateStudentName = $('#updateStudentName').val();
    const updateGender = $('#updateGender').val();
    const updateBirthdate = $('#updateBirthdate').val();
    const updateClassName = $('#updateClassName').val();
    const updateHometown = $('#updateHometown').val();
    const updateEntranceScore = $('#updateEntranceScore').val();

    const updatedStudent = {
        examNumber: parseInt(updateExamNumber),
        name: updateStudentName,
        gender: updateGender,
        birthdate: updateBirthdate,
        className: updateClassName,
        hometown: updateHometown,
        entranceScore: parseInt(updateEntranceScore),
    };

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8089/acstudents/students/update',
        contentType: 'application/json',
        data: JSON.stringify(updatedStudent),
        success: function (data) {
            console.log('学生已更新：', data);
            // 在成功时显示提示框
            alert('学生已成功更新！');
            // 如果需要，添加任何其他成功操作
        },
        error: function (error) {
            console.error('更新学生时出错：', error);

            // 在失败时显示错误提示框
            alert('更新学生时出错，请查看控制台以获取详细信息。');

            // 输出服务器错误的详细信息
            if (error.responseJSON && error.responseJSON.status === 500) {
                console.error('服务器错误：', error.responseJSON);
            }
        }
    });
}


function deleteStudent() {
    const deleteExamNumber = document.getElementById('deleteExamNumber').value;

    fetch(`http://localhost:8089/acstudents/students/delete/${deleteExamNumber}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (response.status === 200) {
                alert('学生删除成功');
                // 这里可以添加其他成功删除的逻辑
            } else if (response.status === 404) {
                alert('学生删除成功');
                // 这里可以添加其他删除失败的逻辑
            } else {
                alert(`删除学生错误: ${response.statusText}`);
                // 这里可以添加其他删除失败的逻辑
            }
        })
        .catch(error => {
            alert(`删除学生错误: ${error.message}`);
            // 这里可以添加其他删除失败的逻辑
        });
}

function fetchAllStudents() {
    fetch('http://localhost:8089/acstudents/students/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('网络响应不正常');
            }
            return response.json();
        })
        .then(data => {
            displayStudents(data);
        })
        .catch(error => {
            console.error('获取学生时出错：', error);
        });
}

function displayStudents(students) {
    console.log('收到的学生数据：', students);

    const studentList = document.getElementById('studentList');
    studentList.innerHTML = '';

    students.forEach(student => {
        console.log('Processing student:', student);
        console.log('Exam Number:', student.examNumber);
        console.log('Student Name:', student.studentName);
        console.log('Grade:', student.grade);

        const listItem = document.createElement('li');
        // 使用正确的属性名
        listItem.textContent = `考号: ${student.examNumber},性别: ${student.gender} ,学生姓名: ${student.name}, 成绩: ${student.entranceScore}, 班级: ${student.className}，生日: ${student.birthdate},籍贯: ${student.hometown}`;
        studentList.appendChild(listItem);
    });
}
function getStudent() {
    const examNumber = $('#examNumberInput').val();

    $.ajax({
        type: 'GET',
        url: `http://localhost:8089/acstudents/students/${examNumber}`,
        success: function (student) {
            displayStudentInfo(student);
        },
        error: function (xhr, textStatus, errorThrown) {
            console.error('获取学生信息时出错：', errorThrown);

            if (xhr.status === 404) {
                alert('学生不存在，请检查输入的考试编号。');
            } else {
                alert('获取学生信息时出错。' + errorThrown);
            }
        }
    });
}

// 显示学生信息的函数（假设有这个函数）
function displayStudentInfo(student) {
    // 清空之前的内容
    $('#studentInfo').empty();

    // 创建并添加学生信息到 div
    const studentInfoDiv = $('<div>');
    studentInfoDiv.append(`<p>姓名: ${student.name}</p>`);
    studentInfoDiv.append(`<p>考号: ${student.examNumber}</p>`);
    studentInfoDiv.append(`<p>生日: ${student.birthdate}</p>`);
    studentInfoDiv.append(`<p>性别: ${student.gender}</p>`);
    studentInfoDiv.append(`<p>班级: ${student.className}</p>`);
    studentInfoDiv.append(`<p>籍贯: ${student.hometown}</p>`);
    studentInfoDiv.append(`<p>高考成绩: ${student.entranceScore}</p>`);
    // 添加更多学生信息的逻辑...

    // 将学生信息 div 添加到页面
    $('#studentInfo').append(studentInfoDiv);
}
