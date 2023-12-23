// 添加学院方法
function addCollege() {
    const collegeId = $('#collegeId').val();
    const collegeName = $('#collegeName').val();
    const collegeAddress = $('#collegeAddress').val();

    const college = {
        collegeId: collegeId,
        collegeName: collegeName,
        collegeAddress: collegeAddress
    };

    $.ajax({
        type: 'POST',  // 确保这里是 POST 方法
        url: 'http://localhost:8089/acstudents/colleges/add',  // 确保请求的路径正确
        contentType: 'application/json',
        data: JSON.stringify(college),
        success: function () {
            alert('学院添加成功！');
            // 在成功时执行其他操作
        },
        error: function (error) {
            console.error('添加学院时出错：', error);

            if (error.responseJSON && error.responseJSON.status === 500) {
                console.error('服务器错误：', error.responseJSON);
            }

            alert('添加学院时出错。请查看控制台以获取详细信息。');
        }
    });
}



// 更新学院方法
function updateCollege() {
    const updateCollegeId = $('#collegeId').val();
    const updateCollegeName = $('#updateCollegeName').val();
    const collegeAddress = $('#collegeAddress1').val();

    const updatedCollege = {
        collegeId: parseInt(updateCollegeId),
        collegeName: updateCollegeName,
        collegeAddress: collegeAddress
    };

    $.ajax({
        type: 'PUT',
        url: `http://localhost:8089/acstudents/colleges/${updateCollegeId}`,
        contentType: 'application/json',
        data: JSON.stringify(updatedCollege),
        success: function () {
            alert('学院信息已成功更新！');
            // 在成功时执行其他操作
        },
        error: function (error) {
            console.error('更新学院信息时出错：', error);

            if (error.responseJSON && error.responseJSON.status === 500) {
                console.error('服务器错误：', error.responseJSON);
            }

            alert('更新学院信息时出错。请查看控制台以获取详细信息。');
        }
    });
}


// 删除学院方法
function deleteCollege() {
    const deleteCollegeId = $('#deleteCollegeId').val();

    $.ajax({
        type: 'DELETE',
        url: `http://localhost:8089/acstudents/colleges/${deleteCollegeId}`,
        success: function () {
            alert('学院删除成功！');
            // 在成功时执行其他操作
        },
        error: function (error) {
            console.error('删除学院时出错：', error);

            if (error.responseJSON && error.responseJSON.status === 500) {
                console.error('服务器错误：', error.responseJSON);
            }

            alert('删除学院时出错。请查看控制台以获取详细信息。');
        }
    });
}

// 获取所有学院方法
function fetchAllColleges() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8089/acstudents/colleges/all',
        success: function (data) {
            displayColleges(data);
        },
        error: function (error) {
            console.error('获取学院列表时出错：', error);
            alert('获取学院列表时出错，请查看控制台以获取详细信息。');
        }
    });
}

function searchCollege() {
    const collegeId = document.getElementById('collegeIdInput').value;

    // 发起 AJAX 请求
    $.ajax({
        type: 'GET',
        url: `http://localhost:8089/acstudents/colleges/${collegeId}`,
        contentType: 'application/json',
        success: function (college) {
            displayCollegeInfo(college);
        },
        error: function (error) {
            console.error('查询学院时出错：', error);
            alert('查询学院时出错。' + error.responseJSON.message);
        }
    });
}
function displayCollegeInfo(college) {
    // 在合适的位置显示学院信息
    alert(`学院编号: ${college.collegeId}, 学院名称: ${college.collegeName}, 学院地址: ${college.collegeAddress}`);
}

function displayColleges(colleges) {
    const collegeList = $('#collegeList');
    collegeList.empty();

    colleges.forEach(college => {
        const listItem = createCollegeListItem(college);
        collegeList.append(listItem);
    });
}

function createCollegeListItem(college) {
    const { collegeId, collegeName, collegeAddress } = college;
    const listItem = $('<li>').text(`学院ID: ${collegeId}, 学院名称: ${collegeName}, 学院地址: ${collegeAddress}`);
    return listItem;
}