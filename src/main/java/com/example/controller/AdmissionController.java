package com.example.controller;

import com.example.pojo.Admission;
import com.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionController {

    private final AdmissionService admissionService;

    @Autowired
    public AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    @PostMapping
    public ResponseEntity<Void> addAdmission(@RequestBody Admission admission) {
        admissionService.addAdmission(admission);
        return new ResponseEntity<>(HttpStatus.CREATED);
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

    @GetMapping
    public ResponseEntity<List<Admission>> getAllAdmissions() {
        List<Admission> admissions = admissionService.getAllAdmissions();
        return new ResponseEntity<>(admissions, HttpStatus.OK);
    }
}
