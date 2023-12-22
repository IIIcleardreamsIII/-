document.addEventListener('DOMContentLoaded', function () {
    // Fetch and display admissions
    fetchAdmissions();

    // Add event listener for form submission
    const addAdmissionForm = document.getElementById('addAdmissionForm');
    addAdmissionForm.addEventListener('submit', function (event) {
        event.preventDefault();
        addAdmission();
    });
});

function fetchAdmissions() {
    fetch('http://localhost:8089/acstudents/admissions')
        .then(response => response.json())
        .then(admissions => {
            const admissionList = document.getElementById('admissionList');
            admissionList.innerHTML = ''; // Clear previous entries

            admissions.forEach(admission => {
                const listItem = document.createElement('li');
                listItem.textContent = `${admission.admissionBatch} - Student ID: ${admission.student.studentId} - College ID: ${admission.college.collegeId}`;
                admissionList.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching admissions:', error));
}

function addAdmission() {
    const admissionBatch = document.getElementById('admissionBatch').value;
    const studentId = document.getElementById('studentId').value;
    const collegeId = document.getElementById('collegeId').value;

    const newAdmission = {
        admissionBatch: admissionBatch,
        student: { studentId: studentId },
        college: { collegeId: collegeId }
    };

    fetch('http://localhost:8089/acstudents/admissions', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newAdmission),
    })
        .then(response => response.json())
        .then(responseData => {
            console.log('Admission added successfully:', responseData);
            fetchAdmissions(); // Refresh the admissions list
            addAdmissionForm.reset(); // Clear the form
        })
        .catch(error => console.error('Error adding admission:', error));
}
