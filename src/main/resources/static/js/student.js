// student.js

function addStudent() {
    const examNumber = document.getElementById('examNumber').value;
    const studentName = document.getElementById('studentName').value;
    const grade = document.getElementById('grade').value;

    const student = {
        examNumber: parseInt(examNumber),
        studentName: studentName,
        grade: grade
    };

    fetch('/students/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(student),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Student added:', data);
        })
        .catch(error => {
            console.error('Error adding student:', error);
        });
}

function updateStudent() {
    const updateExamNumber = document.getElementById('updateExamNumber').value;
    const updateStudentName = document.getElementById('updateStudentName').value;
    const updateGrade = document.getElementById('updateGrade').value;

    const updatedStudent = {
        examNumber: parseInt(updateExamNumber),
        studentName: updateStudentName,
        grade: updateGrade
    };

    fetch('/students/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedStudent),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Student updated:', data);
        })
        .catch(error => {
            console.error('Error updating student:', error);
        });
}

function deleteStudent() {
    const deleteExamNumber = document.getElementById('deleteExamNumber').value;

    fetch(`/students/delete/${deleteExamNumber}`, {
        method: 'DELETE',
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Student deleted:', data);
        })
        .catch(error => {
            console.error('Error deleting student:', error);
        });
}

function fetchAllStudents() {
    fetch('/students/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            displayStudents(data);
        })
        .catch(error => {
            console.error('Error fetching students:', error);
        });
}

function displayStudents(students) {
    const studentList = document.getElementById('studentList');
    studentList.innerHTML = '';

    students.forEach(student => {
        const listItem = document.createElement('li');
        listItem.textContent = `Exam Number: ${student.examNumber}, Student Name: ${student.studentName}, Grade: ${student.grade}`;
        studentList.appendChild(listItem);
    });
}
