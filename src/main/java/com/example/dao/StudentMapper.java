package com.example.dao;

import com.example.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 根据考号查询学生信息
    @Select("SELECT * FROM Student WHERE examNumber = #{examNumber}")
    Student selectStudentById(int examNumber);

    // 插入学生信息
    @Insert("INSERT INTO Student (examNumber, name, gender, birthdate, className, hometown, entranceScore) " +
            "VALUES (#{examNumber}, #{name}, #{gender}, #{birthdate}, #{className}, #{hometown}, #{entranceScore})")
    void insertStudent(Student student);


    // 更新学生信息
    @Update("UPDATE Student SET " +
            "name = #{name}, gender = #{gender}, birthdate = #{birthdate}, " +
            "className = #{className}, hometown = #{hometown}, entranceScore = #{entranceScore} " +
            "WHERE examNumber = #{examNumber}")
    void updateStudent(Student student);


    // 删除学生信息
    @Delete("DELETE FROM Student WHERE examNumber = #{examNumber}")
    void deleteStudent(int examNumber);

    @Select("SELECT * FROM Student")
    List<Student> getAllStudents();

    @Insert("INSERT INTO Student (examNumber, name, gender, birthdate, className, hometown, entranceScore) " +
            "VALUES (#{examNumber}, #{name}, #{gender}, #{birthdate}, #{className}, #{hometown}, #{entranceScore})")
    void addDetailedStudent(Student student);
    // 其他自定义查询方法...
}
