package com.example.dao;

import com.example.pojo.Admission;
import com.example.pojo.College;
import com.example.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdmissionMapper {

    // 插入录取信息
    @Insert("INSERT INTO Admission (admissionId, examNumber, collegeId, admissionBatch) " +
            "VALUES (#{admissionId}, #{examNumber}, #{college.collegeId}, #{admissionBatch})")
    void insertAdmission(Admission admission);

    // 根据录取记录编号查询录取信息
    // 根据录取记录编号查询录取信息，并关联学生和院校信息
    @Select("SELECT a.admissionId, a.admissionBatch, a.examNumber, " +
            "s.examNumber AS student_examNumber, s.name AS student_name, " +
            "c.collegeId AS college_collegeId, c.collegeName AS college_collegeName, c.collegeAddress AS college_collegeAddress " +
            "FROM Admission a " +
            "JOIN Student s ON a.examNumber = s.examNumber " +
            "JOIN College c ON a.collegeId = c.collegeId " +
            "WHERE a.admissionId = #{admissionId}")
    @Results({
            @Result(property = "admissionId", column = "admissionId"),
            @Result(property = "examNumber", column = "examNumber"),
            @Result(property = "admissionBatch", column = "admissionBatch"),
            @Result(property = "student", column = "examNumber",
                    javaType = Student.class,
                    one = @One(select = "com.example.dao.StudentMapper.selectStudentById")),
            @Result(property = "college", column = "collegeId",
                    javaType = College.class,
                    one = @One(select = "com.example.dao.CollegeMapper.selectCollegeById"))
    })
    Admission selectAdmissionById(int admissionId);

    // 更新录取信息
    @Update("UPDATE Admission SET examNumber = #{examNumber}, collegeId = #{college.collegeId}, " +
            "admissionBatch = #{admissionBatch} WHERE admissionId = #{admissionId}")
    void updateAdmission(Admission admission);

    // 删除录取信息
    @Delete("DELETE FROM Admission WHERE admissionId = #{admissionId}")
    void deleteAdmission(int admissionId);

    // 查询所有录取信息
    @Select("SELECT a.admissionId, a.admissionBatch, a.examNumber, " +
            "s.examNumber AS student_examNumber, s.name AS student_name, " +
            "c.collegeId AS college_collegeId, c.collegeName AS college_collegeName, c.collegeAddress AS college_collegeAddress " +
            "FROM Admission a " +
            "JOIN Student s ON a.examNumber = s.examNumber " +
            "JOIN College c ON a.collegeId = c.collegeId")
    @Results({
            @Result(property = "admissionId", column = "admissionId"),
            @Result(property = "examNumber", column = "examNumber"),
            @Result(property = "admissionBatch", column = "admissionBatch"),
            @Result(property = "student", column = "student_examNumber",
                    javaType = Student.class,
                    one = @One(select = "com.example.dao.StudentMapper.selectStudentById")),
            @Result(property = "college", column = "college_collegeId",
                    javaType = College.class,
                    one = @One(select = "com.example.dao.CollegeMapper.selectCollegeById"))
    })
    List<Admission> getAllAdmissions();

    // 其他自定义查询方法...
}

