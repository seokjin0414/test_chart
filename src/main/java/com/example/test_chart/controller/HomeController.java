package com.example.test_chart.controller;

import com.example.test_chart.service.CoinValueService;
import com.example.test_chart.service.ExchangeRateService;
import com.example.test_chart.vo.CoinValue;
import com.example.test_chart.vo.ExchangeRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    CoinValueService coinValueService;

    @Autowired
    ExchangeRateService exchangeRateService;

    @GetMapping("/")
    public String chartGo(Model model) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate = exchangeRateService.selectExchangeRateRecent(exchangeRate);

        if (exchangeRate != null) {

        model.addAttribute("exchangeRate", exchangeRate);
        }

        return "chart/test";
    }

}
