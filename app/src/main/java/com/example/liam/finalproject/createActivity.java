package com.example.liam.finalproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;

public class createActivity extends AppCompatActivity {

    Firebase mRef;
    EditText p1, p2, p3, p4, p5, p6, p7, p8, p9, name;
    Button submit;
    final private String url = "https://diamond-tracker.firebaseio.com/League";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mRef= new Firebase(url);

        TextView title = (TextView) findViewById(R.id.t);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/playball.ttf");
        title.setTypeface(tf);

        p1 = (EditText)findViewById(R.id.edit1);
        p2 = (EditText)findViewById(R.id.edit2);
        p3 = (EditText)findViewById(R.id.edit3);
        p4 = (EditText)findViewById(R.id.edit4);
        p5 = (EditText)findViewById(R.id.edit5);
        p6 = (EditText)findViewById(R.id.edit6);
        p7 = (EditText)findViewById(R.id.edit7);
        p8 = (EditText)findViewById(R.id.edit8);
        p9 = (EditText)findViewById(R.id.edit9);
        name = (EditText)findViewById(R.id.editName);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTeam();
            }
        });


    }
    private void createTeam() {
        if (name.getText().toString() == "" || p1.getText().toString() == "" || p2.getText().toString() == "" || p3.getText().toString() == "" || p4.getText().toString() == "" || p5.getText().toString() == "" || p6.getText().toString() == "" || p7.getText().toString() == "" || p8.getText().toString() == "" || p9.getText() == null) {
            Toast.makeText(getApplicationContext(), "Team could not be added", Toast.LENGTH_LONG).show();
            return;
        }

        int temp = ((MyApplication) this.getApplication()).getCount();
        Firebase teamRef = mRef.child("Team "+temp);

        HashMap<String, Object> team = new HashMap<>();
        team.put("id", ""+temp);
        team.put("pitcher", p1.getText().toString());
        team.put("catcher", p2.getText().toString());
        team.put("first", p3.getText().toString());
        team.put("second", p4.getText().toString());
        team.put("third", p5.getText().toString());
        team.put("shortStop", p6.getText().toString());
        team.put("leftField", p7.getText().toString());
        team.put("centerField", p8.getText().toString());
        team.put("rightField", p9.getText().toString());
        team.put("name", name.getText().toString());
        team.put("url", "http://www.sports-logos-screensavers.com/user/Boston_Red_Sox8.jpg");
        team.put("wins", 0);
        team.put("losses", 0);

        teamRef.updateChildren(team);
        Toast.makeText(getApplicationContext(), "Team added", Toast.LENGTH_LONG).show();

        ((MyApplication) this.getApplication()).incrementCount();

        Intent intent = new Intent(this,AppActivity.class);
        startActivity(intent);
    }
}
