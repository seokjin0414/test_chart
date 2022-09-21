package com.example.test_chart.controller.rest;

import com.example.test_chart.controller.BaseRestController;
import com.example.test_chart.service.ApiService;
import com.example.test_chart.service.CoinValueService;
import com.example.test_chart.service.ExchangeRateService;
import com.example.test_chart.vo.CoinValue;
import com.example.test_chart.vo.ExchangeRate;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RestController
@RequestMapping(value = "/api/chart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChartRestController extends BaseRestController {

    @Autowired
    ApiService apiService;

    @Autowired
    CoinValueService coinValueService;

    @Autowired
    ExchangeRateService exchangeRateService;

    @Scheduled(cron = "0 0/30 * * * *")
    @PostMapping(value = "insertCoinValue")
    public  ResponseEntity<?> insertCoinValue() {
        List<CoinValue> list = apiService.getCoinValueApi();

        for (CoinValue vo : list) {
            int update = coinValueService.insertCoinValue(vo);
        }

        return success("OK");
    }

    @Scheduled(cron = "0 40 8 * * 1-5")
    @PostMapping(value = "insertExchangeRate")
    public ResponseEntity<?> insertExchangeRate() {
        int update = exchangeRateService.insertExchangeRate(apiService.getExchangeRateApi());
        return success("ok");
    }

    @GetMapping(value = "selectCoinValue")
    public List<CoinValue> selectCoinValue(CoinValue vo) {
        return coinValueService.selectWaitingTransferList(vo);
    }

    @GetMapping(value = "selectExchangeRate")
    public ExchangeRate selectExchangeRate(ExchangeRate vo) {
        return exchangeRateService.selectExchangeRateRecent(vo);
    }

    @GetMapping(value = "getCoinValueOfChart")
    List<List<String>> getCoinValueOfChart(CoinValue vo) {
        return coinValueService.getCoinValueOfChart(vo);
    }
}
