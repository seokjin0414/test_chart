package com.example.test_chart.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/chart")
public class chartController {

    @GetMapping("/test")
    public String chartGo() {
        return "chart/test";
    }

    @GetMapping("/test1")
    public String getCoin() {


        String accessKey = "발급받은 Access key";
        String secretKey = "발급받은 Secret key";

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;
try {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://api.upbit.com/v1/trades/ticks?market=USDT-BTC&count=1")
            .get()
            .addHeader("Accept", "application/json")
            .build();

    Response response = client.newCall(request).execute();
    System.out.println(response);

} catch (IOException e) {
    e.printStackTrace();
}



        return "chart/test";
    }


}
