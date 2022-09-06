package com.example.test_chart.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/chart")
public class chartController {

    @GetMapping("/test")
    public String chartGo() {
        return "chart/test";
    }
}
