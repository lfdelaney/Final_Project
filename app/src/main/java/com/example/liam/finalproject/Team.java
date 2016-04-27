package com.example.liam.finalproject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by rdpie_000 on 4/26/2016.
 */
@JsonIgnoreProperties({ "selection" })
public class Team implements Serializable {

    String url, name, id, leftField, rightField, centerField, first, second, third, shortStop, catcher, pitcher;
    int wins,losses;

    public Team(){
    }

    public String getCatcher() {
        return catcher;
    }

    public void setCatcher(String c){
        catcher = c;
    }

    public String getCenterField() {
        return centerField;
    }

    public void setCenterField(String s){
        centerField = s;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String f){ first = f; }

    public String getId() {
        return id;
    }

    public void setId(String i) { id = i; }

    public String getLeftField(){
        return leftField;
    }

    public void setLeftField(String lf) { leftField = lf; }

    public String getRightField(){
        return rightField;
    }

    public void setRightField(String rf) { rightField = rf; }

    public String getPitcher() {
        return pitcher;
    }

    public void setPitcher(String p) { pitcher = p; }

    public String getSecond() {
        return second;
    }

    public void setSecond(String s) { second = s; }

    public String getThird() {
        return third;
    }

    public void setThird(String t) { third = t; }

    public String getShortStop() {
        return shortStop;
    }

    public void setShortStop(String ss){ shortStop = ss; }

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
