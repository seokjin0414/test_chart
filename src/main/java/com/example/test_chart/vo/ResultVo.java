package com.example.test_chart.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultVo {
    private String code;
    private String message;
    private String datetime;
    private String size;
    private Object data;
}
