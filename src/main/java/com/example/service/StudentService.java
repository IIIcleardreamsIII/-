package com.example.service;

import com.example.pojo.Student;

import java.util.List;

public interface StudentService {

    Student getStudentById(int examNumber);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int examNumber);

    // 其他自定义查询方法...
}
