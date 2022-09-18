package com.example.test_chart.controller;

import com.example.test_chart.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class BaseRestController {
    private final Logger L = LoggerFactory.getLogger(this.getClass());


    /**
     * 성공
     * @param data
     * @return
     */
    protected ResponseEntity<?> success(Object data) {
        ResultVo restResult = new ResultVo();
        restResult.setCode("200");
        restResult.setMessage("");
        restResult.setData(data);
        restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return new ResponseEntity<>(restResult, HttpStatus.OK);
    }






}
