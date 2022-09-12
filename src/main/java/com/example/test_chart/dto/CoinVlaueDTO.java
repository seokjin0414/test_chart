package com.example.test_chart.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class CoinVlaueDTO {
    private Long coinVlaueId;
    private String coinKind;
    private Long coinValue;
    private Date coinVlaueRegdate;

}
