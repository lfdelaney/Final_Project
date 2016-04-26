package com.example.liam.finalproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, pickYourTeam.newInstance()).commit();
        }
    }
    public void buttonPress(int select){
        switch (select){
            case (0):
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, newTeam.newInstance()).commit();
            case (1):
//                int teamid = loadTeam()
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, book.newInstance(teamid)).commit();
            default:
                break;
        }
    }
}
