package com.example.pojo;

import java.util.Date;

public class Student {
    private int studentId;  // 考号
    private String name;    // 姓名
    private String gender;  // 性别
    private Date birthdate; // 出生年月
    private String className; // 班级
    private String hometown;  // 籍贯
    private int entranceScore; // 高考成绩

    public Student() {
    }


    // Getters and Setters
    public int getEntranceScore() {
        return entranceScore;
    }

    public void setEntranceScore(int entranceScore) {
        this.entranceScore = entranceScore;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", className='" + className + '\'' +
                ", hometown='" + hometown + '\'' +
                ", entranceScore=" + entranceScore +
                '}';
    }
}

