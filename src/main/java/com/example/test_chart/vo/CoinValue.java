package com.example.test_chart.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@ToString
@Alias("coinValue")
public class CoinValue {

    private Long coin_id;
    private String market;
    private Double tradePrice;
    private String coinValueRegdate;

}
