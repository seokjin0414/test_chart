package com.example.test_chart.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Service
public class ChartService {

    public void getCoinValue() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.upbit.com/v1/candles/minutes/30?market=USDT-BTC&count=1")
                .get()
                .addHeader("Accept", "application/json")
                .build();

        Response response = client.newCall(request).execute();



    }


}
