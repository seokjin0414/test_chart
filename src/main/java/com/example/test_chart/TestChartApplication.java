package com.example.test_chart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TestChartApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestChartApplication.class, args);
    }

}
