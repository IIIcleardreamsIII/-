// Admission.js

$(document).ready(function () {
    // Fetch and display admissions
    fetchAdmissions();

    // Add event listener for form submission
    $('#addAdmissionForm').submit(function (event) {
        event.preventDefault();
        addAdmission();
    });

    // Add event listener for update form submission
    $('#updateAdmissionForm').submit(function (event) {
        event.preventDefault();
        updateAdmission();
    });

    // Other buttons
    $('button[name="fetchAdmissions"]').click(fetchAdmissions);
    $('button[name="fetchAdmissionById"]').click(fetchAdmissionById);
    $('button[name="deleteAdmission"]').click(deleteAdmission);
});

function fetchAdmissions() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8089/acstudents/admissions',
        dataType: 'json',
        success: function (admissions) {
            displayAdmissions(admissions);
        },
        error: function (error) {
            console.error('Error fetching admissions:', error);
        }
    });
}

function fetchAdmissionById() {
    const admissionId = prompt('Enter Admission ID:');
    if (admissionId !== null) {
        $.ajax({
            type: 'GET',
            url: `http://localhost:8089/acstudents/admissions/${admissionId}`,
            dataType: 'json',
            success: function (admission) {
                displayAdmissions([admission]);
            },
            error: function (error) {
                console.error('Error fetching admission by ID:', error);
            }
        });
    }
}

function addAdmission() {
    const admissionBatch = $('#admissionBatch').val();
    const studentId = $('#studentId').val();
    const collegeId = $('#collegeId').val();

    const newAdmission = {
        admissionBatch: admissionBatch,
        student: { studentId: studentId },
        college: { collegeId: collegeId }
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8089/acstudents/admissions',
        contentType: 'application/json',
        data: JSON.stringify(newAdmission),
        success: function (responseData) {
            console.log('Admission added successfully:', responseData);
            fetchAdmissions(); // Refresh the admissions list
            $('#addAdmissionForm')[0].reset(); // Clear the form
        },
        error: function (error) {
            console.error('Error adding admission:', error);
        }
    });
}

function updateAdmission() {
    const updateAdmissionId = $('#updateAdmissionId').val();
    const updateAdmissionBatch = $('#updateAdmissionBatch').val();
    const updateStudentId = $('#updateStudentId').val();
    const updateCollegeId = $('#updateCollegeId').val();

    const updatedAdmission = {
        admissionId: updateAdmissionId,
        admissionBatch: updateAdmissionBatch,
        student: { studentId: updateStudentId },
        college: { collegeId: updateCollegeId }
    };

    $.ajax({
        type: 'PUT',
        url: `http://localhost:8089/acstudents/admissions/${updateAdmissionId}`,
        contentType: 'application/json',
        data: JSON.stringify(updatedAdmission),
        success: function () {
            console.log('Admission updated successfully.');
            fetchAdmissions(); // Refresh the admissions list
            $('#updateAdmissionForm')[0].reset(); // Clear the update form
        },
        error: function (error) {
            console.error('Error updating admission:', error);
        }
    });
}

function deleteAdmission() {
    const admissionId = prompt('Enter Admission ID to delete:');
    if (admissionId !== null) {
        $.ajax({
            type: 'DELETE',
            url: `http://localhost:8089/acstudents/admissions/${admissionId}`,
            success: function () {
                console.log('Admission deleted successfully.');
                fetchAdmissions(); // Refresh the admissions list
            },
            error: function (error) {
                console.error('Error deleting admission:', error);
            }
        });
    }
}

function displayAdmissions(admissions) {
    const admissionList = $('#admissionList');
    admissionList.empty(); // Clear previous entries

    admissions.forEach(admission => {
        const listItem = $('<li>').text(`${admission.admissionBatch} - Student ID: ${admission.student.studentId} - College ID: ${admission.college.collegeId}`);
        admissionList.append(listItem);
    });
}
