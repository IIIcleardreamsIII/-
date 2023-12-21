package com.example.service;

import com.example.pojo.College;

public interface CollegeService {

    void addCollege(College college);

    College getCollegeById(int collegeId);

    void updateCollege(College college);

    void deleteCollege(int collegeId);

    // 其他自定义查询方法...
}
