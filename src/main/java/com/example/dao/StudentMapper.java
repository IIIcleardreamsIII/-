package com.example.dao;

import com.example.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM Student WHERE examNumber = #{examNumber}")
    Student selectStudentById(int examNumber);

    @Insert("INSERT INTO Student (examNumber, name, gender, birthdate, className, hometown, entranceScore) " +
            "VALUES (#{studentId}, #{name}, #{gender}, #{birthdate}, #{className}, #{hometown}, #{entranceScore})")
    void insertStudent(Student student);

    @Update("UPDATE Student SET " +
            "name = #{name}, gender = #{gender}, birthdate = #{birthdate}, " +
            "className = #{className}, hometown = #{hometown}, entranceScore = #{entranceScore} " +
            "WHERE examNumber = #{studentId}")
    void updateStudent(Student student);

    @Delete("DELETE FROM Student WHERE examNumber = #{studentId}")
    void deleteStudent(int examNumber);

    // 其他自定义查询方法...
}
