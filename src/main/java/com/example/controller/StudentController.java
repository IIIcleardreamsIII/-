package com.example.controller;

import com.example.pojo.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/students") // 更改为复数形式，以符合RESTful风格
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // 更改为明确的页面路径
    public String showStudentPage() {
        return "student";
    }

    @GetMapping("/{examNumber}")
    public ResponseEntity<Student> getStudentById(@PathVariable int examNumber) {
        Student student = studentService.getStudentById(examNumber);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        try {
            studentService.addStudent(student);
            // 返回一个空的 JSON 对象
            return new ResponseEntity<>(Collections.emptyMap(), HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{examNumber}")
    public ResponseEntity<Object> deleteStudent(@PathVariable int examNumber) {
        boolean deleted = studentService.deleteStudent(examNumber);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    // 添加详细信息的方法
    @PostMapping("/addDetailed")
    public ResponseEntity<Void> addDetailedStudent(@RequestBody Student student) {
        try {
            studentService.addDetailedStudent(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add other Controller methods if needed...
}
