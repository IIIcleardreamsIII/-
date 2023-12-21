package com.example.dao;

import com.example.pojo.College;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CollegeMapper {

    @Insert("INSERT INTO College (collegeId, collegeName, collegeAddress) " +
            "VALUES (#{collegeId}, #{collegeName}, #{collegeAddress})")
    void insertCollege(College college);
    @Update("UPDATE College SET collegeName = #{collegeName}, collegeAddress = #{collegeAddress} " +
            "WHERE collegeId = #{collegeId}")
    void updateCollege(College college);
    @Select("SELECT * FROM College WHERE collegeId = #{collegeId}")
    College selectCollegeById(int collegeId);

    @Delete("DELETE FROM College WHERE collegeId = #{collegeId}")
    void deleteCollege(int collegeId);

    // 其他自定义查询方法...
}
