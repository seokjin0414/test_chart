package com.example.test_chart.service;


import com.example.test_chart.vo.CoinValue;
import com.example.test_chart.vo.ExchangeRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class ApiService {

    // coin URL list
    private final List<String> coinUrl = new ArrayList<String>() {
        {
            add("https://api.upbit.com/v1/ticker?markets=USDT-BTC");
            add("https://api.upbit.com/v1/ticker?markets=USDT-ETH");
            add("https://api.upbit.com/v1/ticker?markets=USDT-BCH");
            add("https://api.upbit.com/v1/ticker?markets=USDT-DOGE");
            add("https://api.upbit.com/v1/ticker?markets=USDT-XRP");
        }
    };

    // exchangeRate URL list
    private final List<String> exchangeRateUrl = new ArrayList<String>() {
        {
            add("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.JPYUSD");
            add("https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWUSD");
        }
    };

    // GET CoinValue form api
    public List<CoinValue> getCoinValueApi() {
        List<CoinValue> list = new ArrayList<CoinValue>();

        for (String url : coinUrl) {
            CoinValue vo = new CoinValue();
            try {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .method("GET", null)
                        .build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String userString = response.body().string();
                    JSONArray userJson = new JSONArray(userString);
                    JSONObject object = userJson.getJSONObject(0);

                    String market = object.getString("market");
                    String tradePrice = object.getString("trade_price");

                    vo.setMarket(market);
                    vo.setTradePrice(Double.valueOf(tradePrice));
                    list.add(vo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // GET ExchangeRate from api
    public ExchangeRate getExchangeRateApi() {
        ExchangeRate vo = new ExchangeRate();

        for (String url : exchangeRateUrl) {
            try {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .method("GET", null)
                        .build();
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String userString = response.body().string();
                    JSONArray userJson = new JSONArray(userString);
                    JSONObject object = userJson.getJSONObject(0);

                    String code = object.getString("currencyCode");
                    String price = object.getString("basePrice");

                    if (code.equals("JPY")) {
                        vo.setJpy(Double.valueOf(price));
                    } else if (code.equals("USD")) {
                        vo.setKrw(Double.valueOf(price));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vo;
    }

//        String accessKey = "???????????? Access key";
//        String secretKey = "???????????? Secret key";
//
//        Algorithm algorithm = Algorithm.HMAC256(secretKey);
//
//        String jwtToken = JWT.create()
//                .withClaim("access_key", accessKey)
//                .withClaim("nonce", UUID.randomUUID().toString())
//                .sign(algorithm);
//        String authenticationToken = "Bearer " + jwtToken;

//        try {
//            OkHttpClient client = new OkHttpClient();
//            String strURL = "https://quotation-api-cdn.dunamu.com/v1/forex/recent?codes=FRX.KRWUSD";
//            //GET????????? ?????? build ????????? ?????????.
//            Request.Builder builder = new Request.Builder().url(strURL).get();
//            //json??? ???????????? ??????, ????????? ???????????????.
//            builder.addHeader("Content-type", "application/json");
//            //request ????????? ???????????????.
//            Request request = builder.build();
//            //request??? ???????????? ??? ????????? response ????????? ????????? ????????????.
//            Response response = client.newCall(request).execute();
//            //????????????
//            if (response.isSuccessful()) {
//                ResponseBody body = response.body();
//                System.out.println("[responseBody]:" + body.string());
//                body.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

}
