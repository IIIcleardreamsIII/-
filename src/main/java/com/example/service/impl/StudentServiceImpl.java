package com.example.service.impl;

import com.example.dao.StudentMapper;
import com.example.pojo.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student getStudentById(int examNumber) {
        return studentMapper.selectStudentById(examNumber);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int examNumber) {
        studentMapper.deleteStudent(examNumber);
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public void addDetailedStudent(Student student) {
        studentMapper.addDetailedStudent(student);
    }


    // 其他自定义查询方法...
}
