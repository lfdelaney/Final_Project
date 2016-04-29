package com.example.liam.finalproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;

public class PlayActivity extends AppCompatActivity {

    boolean flag;
    String p1,p2;
    Bundle bundle1, bundle2;
    ImageButton button;
    int count;
    Spinner homeSpinner;
    Spinner awaySpinner;
    String[] nameList;
    Long children;
    ArrayAdapter<String> adapter;
    Firebase ref;
    String uID, server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        setContentView(R.layout.activity_play);

        uID = ((MyApplication)getApplication()).getID();
        server = "https://diamond-tracker.firebaseio.com/users/"+ uID+ "/League";
        ref = new Firebase(server);

        TextView title = (TextView) findViewById(R.id.name);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/playball.ttf");
        title.setTypeface(tf);


        homeSpinner = (Spinner)findViewById(R.id.homeTeam);
        awaySpinner = (Spinner)findViewById(R.id.awayTeam);

        nameList = new String[30];
        for(int i =0; i<nameList.length; i++){
            nameList[i] = ""+i;
        }

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();
                Log.d("dSS", dataSnapshot.toString());
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

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nameList);
        homeSpinner.setAdapter(adapter);
        awaySpinner.setAdapter(adapter);
        homeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                p2 = (String) parent.getItemAtPosition(position);
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        awaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                p1 = (String) parent.getItemAtPosition(position);
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button = (ImageButton)findViewById(R.id.playButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(PlayActivity.this, BookView.class);
                share.putExtra("homeTeam", p1);
                share.putExtra("awayTeam", p2);
                startActivity(share);
            }
        });

    }
}
