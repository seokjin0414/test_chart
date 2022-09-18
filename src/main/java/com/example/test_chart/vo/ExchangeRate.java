package com.example.test_chart.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("exchangeRate")
public class ExchangeRate {
    private Long exchangeRateId;
    private Double usd;
    private Double krw;
    private Double jpy;
    private String exchangeRateRegdate;
}
