package com.example.test_chart.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinValue30Min {

    // 마켓명
    private String market;
    // 캔들 기준 시각(UTC 기준) 포맷: yyyy-MM-dd'T'HH:mm:ss
    private String candle_date_time_utc;
    // 캔들 기준 시각(KST 기준) 포맷: yyyy-MM-dd'T'HH:mm:ss
    private String candle_date_time_kst;
    // 시가
    private Double opening_price;
    // 고가
    private Double high_price;
    // 저가
    private Double low_price;
    // 종가
    private Double trade_price;
    // 해당 캔들에서 마지막 틱이 저장된 시각
    private Long timestamp;
    // 누적 거래 금액
    private Double candle_acc_trade_price;
    // 누적 거래량
    private Double candle_acc_trade_volume;
    // 분 단위(유닛)
    private Integer unit;

}
