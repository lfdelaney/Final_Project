package com.example.liam.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    Spinner homeSpinner;
    Spinner awaySpinner;
    String[] nameList = new String[]{};
    ArrayAdapter<String> adapter;
    TeamData team = new TeamData();
    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //homeSpinner = (Spinner)findViewById(R.id.homeTeam);
        //awaySpinner = (Spinner)findViewById(R.id.awayTeam);


        for(int i = 0; i<= team.getSize(); i++){
            temp = (String)team.getItem(i).get("name");
            nameList[i] = temp;
            Log.d("Team List: ", temp);
        }



        //adapter = new ArrayAdapter<String>(this,R.layout.spinner_layout, nameList);
        homeSpinner.setAdapter(adapter);
        awaySpinner.setAdapter(adapter);

        homeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked Home Team Spinner Item", Toast.LENGTH_LONG).show();
            }
        });

        awaySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked Away Team Spinner Item", Toast.LENGTH_LONG).show();
            }
        });


    }
}
