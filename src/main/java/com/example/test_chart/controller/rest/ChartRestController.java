package com.example.test_chart.controller.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/chart", produces= MediaType.APPLICATION_JSON_VALUE)
public class ChartRestController {
}
