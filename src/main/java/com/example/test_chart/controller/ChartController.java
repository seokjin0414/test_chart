package com.example.test_chart.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.test_chart.vo.CoinValue30Min;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

//
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
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://api.upbit.com/v1/candles/minutes/30?market=USDT-BTC&count=1")
                    .method("GET", null)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String userString = response.body().string();
                JSONArray userJson = new JSONArray(userString);
                JSONObject object  = userJson.getJSONObject(0);
                System.out.println(object);

                String a1= object.getString("market");
                String a2 = object.getString("candle_date_time_kst");
                String a3 = object.getString("trade_price");
                System.out.println(a1 + a2 + a3);
                CoinValue30Min a = new CoinValue30Min();



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


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
