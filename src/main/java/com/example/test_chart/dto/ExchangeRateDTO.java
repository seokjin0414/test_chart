package com.example.test_chart.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class ExchangeRateDTO {
    private Long exchangeRateId;
    private Long usd;
    private Long krw;
    private Long jpy;
    private Date exchangeRateRegdate;
}
