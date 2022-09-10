package com.example.test_chart.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;


@Slf4j
@RequiredArgsConstructor
@Service
public class chartService {

    public void getCoinValue() {


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.upbit.com/v1/trades/ticks?count=1")
                .get()
                .addHeader("Accept", "application/json")
                .build();

    }


}
