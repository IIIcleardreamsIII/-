package com.example;

import com.example.controller.CollegeController;
import com.example.dao.CollegeMapper;
import com.example.service.impl.CollegeServiceImpl;
import com.example.util.mybatisUtils;
public class collegeTest {
    public static void main(String[] args) {
        CollegeMapper collegeMapper = mybatisUtils.getSession().getMapper(CollegeMapper.class);
        CollegeController collegeController = new CollegeController(new CollegeServiceImpl(collegeMapper));
        collegeController.getCollegeById(11);

    }
}
