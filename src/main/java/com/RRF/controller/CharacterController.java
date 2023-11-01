package com.RRF.controller;

import com.RRF.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping(value="/")
    public String Hello(){
        return "Hello, from Rick & Morty Planet !!";
    }

    @GetMapping(value="search-character-appaerance/{name}", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    public String searchCharacterAppaerance(@PathVariable("name") String name) throws URISyntaxException, IOException, InterruptedException {
        String responseCharacter =  characterService.searchCharacterAppaerance(name);

        if (responseCharacter == null){
            responseCharacter = "¡¡ The character, " + name.replace("+"," ") + ", DOESN'T EXIST !!";
        }
        return responseCharacter;
    }

}
