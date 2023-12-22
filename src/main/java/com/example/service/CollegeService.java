package com.example.service;

import com.example.pojo.College;

import java.util.List;

public interface CollegeService {

    void addCollege(College college);

    College getCollegeById(int collegeId);

    void updateCollege(College college);

    void deleteCollege(int collegeId);

    List<College> getAllColleges();

    // 其他自定义查询方法...
}
