package com.RRF.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RestService {

    JsonArray giveMeJsonArray(String url, String model) throws URISyntaxException, IOException, InterruptedException;

    JsonObject giveMeJsonObjeto(String url) throws URISyntaxException, IOException, InterruptedException;
}
