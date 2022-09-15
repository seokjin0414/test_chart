package com.example.test_chart.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.test_chart.vo.CoinValue30Min;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/chart")
public class ChartController {

    @GetMapping("/test")
    public String chartGo() {
        return "chart/test";
    }

    @GetMapping("/test1")
    public String getCoin() {


//        String accessKey = "발급받은 Access key";
//        String secretKey = "발급받은 Secret key";
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        String jwtToken = JWT.create()
//                .withClaim("access_key", accessKey)
//                .withClaim("nonce", UUID.randomUUID().toString())
//                .sign(algorithm);
//        String authenticationToken = "Bearer " + jwtToken;


        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://api.upbit.com/v1/candles/minutes/30?market=USDT-BTC&count=1";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println(body.string());

//                JSONObject userJson = new JSONObject(a);

                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://api.upbit.com/v1/candles/minutes/30?market=USDT-ETH&count=1";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "application/json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println("[responseBody]:" + body.string());
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://api.upbit.com/v1/candles/minutes/30?market=USDT-BCH&count=1";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "application/json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println("[responseBody]:" + body.string());
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://api.upbit.com/v1/candles/minutes/30?market=BTC-SOL&count=1";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "application/json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println("[responseBody]:" + body.string());
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.JPYUSD";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "application/json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println("[responseBody]:" + body.string());
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            OkHttpClient client = new OkHttpClient();
            String strURL = "https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWUSD";
            //GET요청을 위한 build 작업을 합니다.
            Request.Builder builder = new Request.Builder().url(strURL).get();
            //json을 주고받는 경우, 헤더에 추가합니다.
            builder.addHeader("Content-type", "application/json");
            //request 객체를 생성합니다.
            Request request = builder.build();
            //request를 요청하고 그 결과를 response 객체로 응답을 받습니다.
            Response response = client.newCall(request).execute();
            //응답처리
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                System.out.println("[responseBody]:" + body.string());
                body.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "chart/test";
    }


}
