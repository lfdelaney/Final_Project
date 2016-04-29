package com.example.liam.finalproject;

import android.app.Application;

/**
 * Created by Liam on 4/27/16.
 */
public class MyApplication extends Application {
    private int teamCount;
    private String uID;

    public String getID()  { return uID;}
    public void setuID(String i) {
        uID = i;
    }
    public int getCount(){
        return teamCount;
    }
    public void incrementCount(){
        teamCount++;
    }
    public void setTeamCount(int t){
        teamCount = t;
    }

}
