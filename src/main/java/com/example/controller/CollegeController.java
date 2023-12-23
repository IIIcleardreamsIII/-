package com.example.controller;

import com.example.pojo.College;
import com.example.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }
    @GetMapping // 更改为明确的页面路径
    public String showStudentPage() {
        return "colleges";
    }
    @GetMapping("/all")
    public ResponseEntity<List<College>> getAllColleges() {
        List<College> colleges = collegeService.getAllColleges();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> addCollege(@RequestBody College college) {
        try {
            // 调用 service 添加学院
            collegeService.addCollege(college);
            // 添加日志输出
            System.out.println("College added successfully: " + college);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            // 添加日志输出
            System.err.println("Failed to add college. Exception: " + e.getMessage());
            // 处理异常，例如数据库插入失败
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{collegeId}")
    public ResponseEntity<College> getCollegeById(@PathVariable int collegeId) {
        College college = collegeService.getCollegeById(collegeId);
        return college != null
                ? new ResponseEntity<>(college, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{collegeId}")
    public ResponseEntity<String> updateCollege(@PathVariable int collegeId, @RequestBody College college) {
        College existingCollege = collegeService.getCollegeById(collegeId);
        if (existingCollege != null) {
            college.setCollegeId(collegeId);
            collegeService.updateCollege(college);
            return new ResponseEntity<>("College updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("College not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{collegeId}")
    public ResponseEntity<String> deleteCollege(@PathVariable int collegeId) {
        College existingCollege = collegeService.getCollegeById(collegeId);
        if (existingCollege != null) {
            collegeService.deleteCollege(collegeId);
            return new ResponseEntity<>("College deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("College not found.", HttpStatus.NOT_FOUND);
        }
    }
}

