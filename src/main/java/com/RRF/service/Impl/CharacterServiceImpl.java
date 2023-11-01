package com.RRF.service.Impl;

import com.RRF.model.Episode;
import com.RRF.model.JsonEndPoint;
import com.RRF.model.Results;
import com.RRF.service.CharacterService;
import com.RRF.service.RestService;
import com.RRF.utils.DateUtils;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    String url="https://rickandmortyapi.com/api/character/";
    @Autowired
    RestService restService;

    @Override
    public String searchCharacterAppaerance(String name) throws URISyntaxException, IOException, InterruptedException {
        JsonArray jsonArrayObj = restService.giveMeJsonArray(url + "/?name=" + name, "results");

        if(jsonArrayObj != null) {
            Gson gson = new Gson();
            JsonEndPoint jsonEndPoint = new JsonEndPoint();
            Results results = new Results();
            List<Results> resultsList = new ArrayList<>();

            ArrayList<String> listEpisodes = new ArrayList<>();
            if (jsonArrayObj.isEmpty()) {
                return null;
            } else {
                results = gson.fromJson(jsonArrayObj.get(0).getAsJsonObject(), Results.class);
                resultsList.add(results);

                for (Results result : resultsList) {
                    for (String episodeActual : result.getEpisode()) {
                        JsonObject arrayEpisode = restService.giveMeJsonObjeto(episodeActual);
                        Episode episodeObj = gson.fromJson(arrayEpisode.getAsJsonObject(), Episode.class);
                        listEpisodes.add(episodeObj.getName());
                    }
                }

                results = gson.fromJson(jsonArrayObj.get(0).getAsJsonObject(), Results.class);
                String firstEpisode = results.getEpisode().get(0);

                JsonObject arrayEpisode = restService.giveMeJsonObjeto(firstEpisode);
                Episode firstEpisodeObj = gson.fromJson(arrayEpisode.getAsJsonObject(), Episode.class);


                jsonEndPoint.setName(results.getName());
                jsonEndPoint.setEpisodes(listEpisodes);
                jsonEndPoint.setFirst_appearance(DateUtils.formatoFechaJson(firstEpisodeObj.getAir_date()));


            }

            String response = gson.toJson(jsonEndPoint);
            return response;
        }else {
            return null;
        }
    }

}
