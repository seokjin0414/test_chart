package com.example.test_chart.controller.rest;

import com.example.test_chart.controller.BaseRestController;
import com.example.test_chart.service.ApiService;
import com.example.test_chart.service.CoinValueService;
import com.example.test_chart.service.ExchangeRateService;
import com.example.test_chart.vo.CoinValue;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/chart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChartRestController extends BaseRestController {

    @Autowired
    ApiService apiService;

    @Autowired
    CoinValueService coinValueService;

    @Autowired
    ExchangeRateService exchangeRateService;

    private final List<String> coinUrl = new ArrayList<String>() {
        {
            add("https://api.upbit.com/v1/candles/minutes/30?market=USDT-BTC&count=1");
            add("https://api.upbit.com/v1/candles/minutes/30?market=USDT-ETH&count=1");
            add("https://api.upbit.com/v1/candles/minutes/30?market=USDT-BCH&count=1");
            add("https://api.upbit.com/v1/candles/minutes/30?market=USDT-DOGE&count=1");
            add("https://api.upbit.com/v1/candles/minutes/30?market=USDT-XRP&count=1");
        }
    };

    private final List<String> exchangeRateUrl = new ArrayList<String>() {
        {
            add("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.JPYUSD");
            add("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWUSD");
        }
    };

    @PostMapping(value = "insertCoinValue")
    public  ResponseEntity<?> insertCoinValue() {
        List<CoinValue> list = apiService.getCoinValueApi();
        for (CoinValue vo : list) {
            int update = coinValueService.insertCoinValue(vo);

        }

        return success("OK");
    }

    @PostMapping(value = "insertExchangeRate")
    public ResponseEntity<?> insertExchangeRate() {
        int update = exchangeRateService.insertExchangeRate(apiService.getExchangeRateApi());

        return success("ok");
    }

}
