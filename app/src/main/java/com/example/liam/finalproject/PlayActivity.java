package com.example.liam.finalproject;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;

public class PlayActivity extends AppCompatActivity {

    int count = 0;
    int flag = -2;
    Spinner homeSpinner;
    Spinner awaySpinner;
    String[] nameList;
    ArrayAdapter<String> adapter;
    Firebase ref = new Firebase("https://diamond-tracker.firebaseio.com/League");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView title = (TextView) findViewById(R.id.name);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/playball.ttf");
        title.setTypeface(tf);

         nameList = new String[100];

        homeSpinner = (Spinner)findViewById(R.id.homeTeam);
        awaySpinner = (Spinner)findViewById(R.id.awayTeam);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                nameList[count] = (String) team.get("name");
                Log.d("Added to list: ", nameList[count]);
                count++;
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        if(flag == count) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nameList);
            homeSpinner.setAdapter(adapter);
            awaySpinner.setAdapter(adapter);
            homeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Log.v("item", (String) parent.getItemAtPosition(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });
            awaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Log.v("item", (String) parent.getItemAtPosition(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub
                }
            });
        }else{
            flag++;
            Log.d("FLAG = ", "false");
        }
    }
}
