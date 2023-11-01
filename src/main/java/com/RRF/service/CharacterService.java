package com.RRF.service;

import com.RRF.model.Results;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface CharacterService {

    String searchCharacterAppaerance(String name) throws URISyntaxException, IOException, InterruptedException;


}
