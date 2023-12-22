package com.example.controller;

import com.example.pojo.Admission;
import com.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAdmission(@RequestBody Admission admission) {
        try {
            admissionService.addAdmission(admission);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 表示成功，返回204状态码
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 表示失败，返回400状态码
        }
    }


    @GetMapping
    public String admissionPage() {
        return "Admission"; // This maps to src/main/resources/static/Admission.html
    }

    @GetMapping("/{admissionId}")
    public ResponseEntity<Admission> getAdmissionById(@PathVariable int admissionId) {
        Admission admission = admissionService.getAdmissionById(admissionId);
        return admission != null
                ? new ResponseEntity<>(admission, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{admissionId}")
    public ResponseEntity<Void> updateAdmission(@PathVariable int admissionId, @RequestBody Admission admission) {
        Admission existingAdmission = admissionService.getAdmissionById(admissionId);
        if (existingAdmission != null) {
            admission.setAdmissionId(admissionId);
            admissionService.updateAdmission(admission);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{admissionId}")
    public ResponseEntity<Void> deleteAdmission(@PathVariable int admissionId) {
        Admission existingAdmission = admissionService.getAdmissionById(admissionId);
        if (existingAdmission != null) {
            admissionService.deleteAdmission(admissionId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")  // 不要包含 /admissions，因为在类上已经有 @RequestMapping("/admissions")
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        List<Admission> admissions = admissionService.getAllAdmissions();
        return new ResponseEntity<>(admissions, HttpStatus.OK);
    }

}
