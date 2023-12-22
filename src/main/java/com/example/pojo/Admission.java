package com.example.pojo;

public class Admission {
    private int admissionId;      // 录取记录编号
    private int examNumber;       // 考号
    private Student student;      // 学生信息
    private College college;      // 录取院校信息
    private String admissionBatch; // 录取批次

    // Getters and Setters

    public int getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(int admissionId) {
        this.admissionId = admissionId;
    }

    public int getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(int examNumber) {
        this.examNumber = examNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public String getAdmissionBatch() {
        return admissionBatch;
    }

    public void setAdmissionBatch(String admissionBatch) {
        this.admissionBatch = admissionBatch;
    }

    @Override
    public String toString() {
        return "Admission{" +
                "admissionId=" + admissionId +
                ", examNumber=" + examNumber +
                ", student=" + student +
                ", college=" + college +
                ", admissionBatch='" + admissionBatch + '\'' +
                '}';
    }
}
