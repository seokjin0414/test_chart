package com.example.test_chart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class homeController {

    @GetMapping("/")
    public String goHome(Model model) {

        model.addAttribute("hello", "서버에서 보내준 값입니다");
        return "home";

    }

}
