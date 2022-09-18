package com.example.test_chart.service;

import com.example.test_chart.repository.ExchangeRateRepository;
import com.example.test_chart.vo.ExchangeRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate selectExchangeRateRecent(ExchangeRate vo) {
        return exchangeRateRepository.selectExchangeRateRecent(vo);
    }

    public int insertExchangeRate(ExchangeRate vo) {
        return exchangeRateRepository.insertExchangeRate(vo);
    }

}
