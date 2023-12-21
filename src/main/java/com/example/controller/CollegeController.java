package com.example.controller;

import com.example.pojo.College;
import com.example.service.CollegeService;
import com.example.util.mybatisUtils;
import com.example.dao.CollegeMapper;
import org.apache.ibatis.session.SqlSession;

public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    public void getCollegeById(int collegeId) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
            College college = collegeService.getCollegeById(collegeId);
            System.out.println(college);
        }
    }

    public void addCollege(College college) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
            collegeService.addCollege(college);
            sqlSession.commit();
            System.out.println("College added successfully.");
        }
    }

    public void updateCollege(College college) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
            collegeService.updateCollege(college);
            sqlSession.commit();
            System.out.println("College updated successfully.");
        }
    }

    public void deleteCollege(int collegeId) {
        try (SqlSession sqlSession = mybatisUtils.getSession()) {
            CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
            collegeService.deleteCollege(collegeId);
            sqlSession.commit();
            System.out.println("College deleted successfully.");
        }
    }

    // Add other Controller methods if needed...

}
