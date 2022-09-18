package com.example.test_chart.controller;

import com.example.test_chart.service.ExchangeRateService;
import com.example.test_chart.vo.ExchangeRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    ExchangeRateService exchangeRateService;

    @GetMapping("/")
    public String chartGo(Model model) {
        ExchangeRate vo = new ExchangeRate();
        ExchangeRate exchangeRate = exchangeRateService.selectExchangeRateRecent(vo);
        model.addAttribute("exchangeRate", exchangeRate);

        return "chart/test";
    }

}
