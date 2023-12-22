package com.example.dao;

import com.example.pojo.College;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollegeMapper {

    // 插入院校信息
    @Insert("INSERT INTO College (collegeId, collegeName, collegeAddress) " +
            "VALUES (#{collegeId}, #{collegeName}, #{collegeAddress})")
    void insertCollege(College college);

    // 更新院校信息
    @Update("UPDATE College SET collegeName = #{collegeName}, collegeAddress = #{collegeAddress} " +
            "WHERE collegeId = #{collegeId}")
    void updateCollege(College college);

    // 根据院校编号查询院校信息
    @Select("SELECT * FROM College WHERE collegeId = #{collegeId}")
    College selectCollegeById(int collegeId);

    // 删除院校信息
    @Delete("DELETE FROM College WHERE collegeId = #{collegeId}")
    void deleteCollege(int collegeId);

    @Select("SELECT * FROM College")
    List<College> getAllColleges();
    // 其他自定义查询方法...
}
