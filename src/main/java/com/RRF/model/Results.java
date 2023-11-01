package com.RRF.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Results {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Map<String, String> origin;
    //origin
    //name
    //url
    private Map<String, String> location;
    //location
    //name
    //url
    private String image;
    private List<String> episode;
    private String url;
    private String created;

}
