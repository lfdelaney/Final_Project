package com.example.liam.finalproject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by rdpie_000 on 4/26/2016.
 */
@JsonIgnoreProperties({ "selection" })
public class Team implements Serializable {

    String url, name;
    int wins,losses;

    public Team(){
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String u) {
        url = u;
    }

    public String getName(){return name;}

    public void setName(String n){name = n;}

    public int getWins(){return wins;}

    public void setWins(int w){wins = w;}

    public int getLosses(){return losses;}

    public void setLosses(int l){losses = l;}

}
