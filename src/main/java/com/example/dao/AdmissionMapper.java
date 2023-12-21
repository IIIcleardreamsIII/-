package com.example.dao;

import com.example.pojo.Admission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdmissionMapper {

    @Insert("INSERT INTO Admission (admissionId, studentId, collegeId, admissionBatch) " +
            "VALUES (#{admissionId}, #{student.studentId}, #{college.collegeId}, #{admissionBatch})")
    void insertAdmission(Admission admission);

    @Select("SELECT a.admissionId, a.admissionBatch, s.*, c.* " +
            "FROM Admission a " +
            "JOIN Student s ON a.studentId = s.studentId " +
            "JOIN College c ON a.collegeId = c.collegeId " +
            "WHERE a.admissionId = #{admissionId}")
    Admission selectAdmissionById(int admissionId);

    @Update("UPDATE Admission SET studentId = #{student.studentId}, collegeId = #{college.collegeId}, " +
            "admissionBatch = #{admissionBatch} WHERE admissionId = #{admissionId}")
    void updateAdmission(Admission admission);

    @Delete("DELETE FROM Admission WHERE admissionId = #{admissionId}")
    void deleteAdmission(int admissionId);

    @Select("SELECT a.admissionId, a.admissionBatch, s.*, c.* " +
            "FROM Admission a " +
            "JOIN Student s ON a.studentId = s.studentId " +
            "JOIN College c ON a.collegeId = c.collegeId")
    List<Admission> getAllAdmissions();

    // 其他自定义查询方法...
}