package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/admission")
    public String admissionPage() {
        return "Admission"; // This maps to src/main/resources/static/Admission.html
    }
}
