package com.example.controller;

import com.example.pojo.Student;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;
import com.example.util.mybatisUtils;
import com.example.dao.StudentMapper;
import org.apache.ibatis.session.SqlSession;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void getStudentById(int examNumber) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentService.getStudentById(examNumber);
            System.out.println(student);
        }
    }

    public void addStudent(Student student) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentService.addStudent(student);
            sqlSession.commit();
            System.out.println("Student added successfully.");
        }
    }

    public void updateStudent(Student student) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentService.updateStudent(student);
            sqlSession.commit();
            System.out.println("Student updated successfully.");
        }
    }

    public void deleteStudent(int examNumber) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentService.deleteStudent(examNumber);
            sqlSession.commit();
            System.out.println("Student deleted successfully.");
        }
    }

    // Add other Controller methods if needed...

}
