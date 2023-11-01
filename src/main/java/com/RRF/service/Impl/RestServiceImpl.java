package com.RRF.service.Impl;

import com.RRF.service.RestService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RestServiceImpl implements RestService {
    @Override
    public JsonArray giveMeJsonArray(String url, String model) throws URISyntaxException, IOException, InterruptedException {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


            JsonParser parserObj = new JsonParser();
            JsonElement jsonEleObj = parserObj.parse(getResponse.body());
            JsonObject jsonObj = jsonEleObj.getAsJsonObject();


            JsonArray jsonArrayObj = jsonObj.get(model).getAsJsonArray();

            return jsonArrayObj;
        }catch (RuntimeException e) {
            return null;
        }

    }
    @Override
    public JsonObject giveMeJsonObjeto(String url) throws URISyntaxException, IOException, InterruptedException {
        try{
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());


            JsonParser parserObj = new JsonParser();
            JsonElement jsonEleObj = parserObj.parse(getResponse.body());
            JsonObject jsonObj = jsonEleObj.getAsJsonObject();


            return jsonObj;
        }catch (RuntimeException e) {
            return null;
        }

    }
}
