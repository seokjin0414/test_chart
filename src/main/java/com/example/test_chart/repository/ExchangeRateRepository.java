package com.example.test_chart.repository;

import com.example.test_chart.vo.ExchangeRate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExchangeRateRepository {

    // select exchangeRate recent(1)
    ExchangeRate selectExchangeRateRecent(ExchangeRate vo);

    // insert exchangeRate
    int insertExchangeRate(ExchangeRate vo);

}
