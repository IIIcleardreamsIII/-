package com.example.controller;

import com.example.pojo.College;
import com.example.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping("/{collegeId}")
    public College getCollegeById(@PathVariable int collegeId) {
        return collegeService.getCollegeById(collegeId);
    }

    @PostMapping
    public String addCollege(@RequestBody College college) {
        collegeService.addCollege(college);
        return "College added successfully.";
    }

    @PutMapping("/{collegeId}")
    public String updateCollege(@PathVariable int collegeId, @RequestBody College college) {
        College existingCollege = collegeService.getCollegeById(collegeId);
        if (existingCollege != null) {
            college.setCollegeId(collegeId);
            collegeService.updateCollege(college);
            return "College updated successfully.";
        } else {
            return "College not found.";
        }
    }

    @DeleteMapping("/{collegeId}")
    public String deleteCollege(@PathVariable int collegeId) {
        College existingCollege = collegeService.getCollegeById(collegeId);
        if (existingCollege != null) {
            collegeService.deleteCollege(collegeId);
            return "College deleted successfully.";
        } else {
            return "College not found.";
        }
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // Add other Controller methods if needed...

}
