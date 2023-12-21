package com.example;

import com.example.controller.StudentController;
import com.example.dao.StudentMapper;
import com.example.service.impl.StudentServiceImpl;
import com.example.util.mybatisUtils;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("com.example.dao")
public class studentTest {

    public static void main(String[] args) {
//        Student student = new Student();
//        student.setStudentId(1006);
//        student.setName("John Doe");
//        student.setGender("Male");
//
//        // Setting birthdate using SimpleDateFormat
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date birthdate = dateFormat.parse("2000-01-15");
//            student.setBirthdate(birthdate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        student.setClassName("ClassA");
//        student.setHometown("CityX");
//        student.setEntranceScore(750);
//        StudentMapper studentMapper = mybatisUtils.getSession().getMapper(StudentMapper.class);
//        StudentController studentController = new StudentController(new StudentServiceImpl(studentMapper));
//        studentController.addStudent(student);
//        以上为添加学生测试

        StudentMapper studentMapper = mybatisUtils.getSession().getMapper(StudentMapper.class);
        StudentController studentController = new StudentController(new StudentServiceImpl(studentMapper));
        studentController.deleteStudent(1006);
        //以上为删除学生测试

    }
}