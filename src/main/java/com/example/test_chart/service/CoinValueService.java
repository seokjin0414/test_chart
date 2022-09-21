package com.example.test_chart.service;

import com.example.test_chart.repository.CoinValueRepository;
import com.example.test_chart.vo.CoinValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoinValueService {

    private final CoinValueRepository coinValueRepository;

    public List<CoinValue> selectWaitingTransferList(CoinValue vo) {
        List<CoinValue> result = coinValueRepository.selectCoinValueList(vo);
        return result;
    }

    public int insertCoinValue(CoinValue vo) {
        return coinValueRepository.insertCoinValue(vo);
    }

    public List<List<String>> getCoinValueOfChart(CoinValue vo) {

        List<CoinValue> list = coinValueRepository.selectCoinValueList(vo);
        int cnt = list.size()/5;

        // 0:date, 1:BTC, 2:ETH, 3:BCH 4:DOGE, 5:XRP
        List<List<String>> valueOfChart = new ArrayList<>(5);
        List<String> dataBTC = new ArrayList<>();
        List<String> dataETH = new ArrayList<>();
        List<String> dataBCH = new ArrayList<>();
        List<String> dataDOGE = new ArrayList<>();
        List<String> dataXRP = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        for (CoinValue cv : list) {
            if (cv.getMarket().equals("USDT-BTC")) {
                dataBTC.add(String.valueOf(cv.getTradePrice()));
            } else if (cv.getMarket().equals("USDT-ETH")) {
                dataETH.add(String.valueOf(cv.getTradePrice()));
            } else if (cv.getMarket().equals("USDT-BCH")) {
                dataBCH.add(String.valueOf(cv.getTradePrice()));
            } else if (cv.getMarket().equals("USDT-DOGE")) {
                dataDOGE.add(String.valueOf(cv.getTradePrice()));
            } else if (cv.getMarket().equals("USDT-XRP")) {
                dataXRP.add(String.valueOf(cv.getTradePrice()));
            }

            if (labels.size() < cnt) {
                labels.add(cv.getCoinValueRegdate());
            }
        }

        valueOfChart.add(labels);
        valueOfChart.add(dataBTC);
        valueOfChart.add(dataETH);
        valueOfChart.add(dataBCH);
        valueOfChart.add(dataDOGE);
        valueOfChart.add(dataXRP);



        return valueOfChart;
    }
}
