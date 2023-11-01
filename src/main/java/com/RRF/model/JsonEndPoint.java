package com.RRF.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class JsonEndPoint {
    public String name;
    public ArrayList<String> episodes;
    public String first_appearance;
}
