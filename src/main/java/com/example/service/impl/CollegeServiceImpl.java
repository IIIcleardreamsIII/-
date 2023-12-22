package com.example.service.impl;

import com.example.dao.CollegeMapper;
import com.example.pojo.College;
import com.example.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeMapper collegeMapper;

    @Autowired
    public CollegeServiceImpl(CollegeMapper collegeMapper) {
        this.collegeMapper = collegeMapper;
    }

    @Override
    public void addCollege(College college) {
        collegeMapper.insertCollege(college);
    }

    @Override
    public College getCollegeById(int collegeId) {
        return collegeMapper.selectCollegeById(collegeId);
    }

    @Override
    public void updateCollege(College college) {
        collegeMapper.updateCollege(college);
    }

    @Override
    public void deleteCollege(int collegeId) {
        collegeMapper.deleteCollege(collegeId);
    }

    @Override
    public List<College> getAllColleges() {
        return collegeMapper.getAllColleges();
    }

    // 其他自定义查询方法的实现...
}
