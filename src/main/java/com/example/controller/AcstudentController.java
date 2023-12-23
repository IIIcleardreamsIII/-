package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping // 更新RequestMapping的值
public class AcstudentController {
    @GetMapping
    public String admissionPage() {
        return "acstudent";
    }
}

