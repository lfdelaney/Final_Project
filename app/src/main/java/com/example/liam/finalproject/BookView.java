package com.example.liam.finalproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Objects;

public class BookView extends AppCompatActivity implements bookViewPager.OnFragmentInteractionListener {

    private Firebase mRef = new Firebase("https://diamond-tracker.firebaseio.com/League");
    private String homeName, awayName;
    private HashMap<String, ?>homeTeam, awayTeam;
    private Switch aSwitch;
    private Bundle hBundle, aBundle;
    private int numOuts = 0;
    private EditText homeScore, awayScore;
    private int hS, aS;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.pager, bookViewPager.newInstance()).commit();
        }

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(new myAdapt(getSupportFragmentManager()));

        Bundle bundle = getIntent().getExtras();
        homeName = bundle.getString("homeTeam");
        awayName = bundle.getString("awayTeam");

        homeScore = (EditText)findViewById(R.id.homeScore);
        awayScore = (EditText)findViewById(R.id.awayScore);
        submit = (Button)findViewById(R.id.submitBut);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();

                if (homeName.equalsIgnoreCase((String) team.get("name"))) {
                    homeTeam = team;
                    hBundle = new Bundle();
                    hBundle.putString("catcher",(String)team.get("catcher"));
                    hBundle.putString("centerField", (String) team.get("centerField"));
                    hBundle.putString("first", (String) team.get("first"));
                    hBundle.putString("leftField", (String) team.get("leftField"));
                    hBundle.putString("name",(String)team.get("name"));
                    hBundle.putString("pitcher",(String)team.get("pitcher"));
                    hBundle.putString("rightField",(String)team.get("rightField"));
                    hBundle.putString("second",(String)team.get("second"));
                    hBundle.putString("shortStop",(String)team.get("shortStop"));
                    hBundle.putString("third",(String)team.get("third"));
                    Log.d("HOM: ", homeTeam.toString());
                    loadTeam(hBundle);
                }
                if (awayName.equalsIgnoreCase((String) team.get("name"))) {
                    awayTeam = team;
                    aBundle = new Bundle();
                    aBundle.putString("catcher",(String)team.get("catcher"));
                    aBundle.putString("centerField",(String)team.get("centerField"));
                    aBundle.putString("first", (String) team.get("first"));
                    aBundle.putString("leftField", (String) team.get("leftField"));
                    aBundle.putString("name",(String)team.get("name"));
                    aBundle.putString("pitcher",(String)team.get("pitcher"));
                    aBundle.putString("rightField",(String)team.get("rightField"));
                    aBundle.putString("second",(String)team.get("second"));
                    aBundle.putString("shortStop",(String)team.get("shortStop"));
                    aBundle.putString("third",(String)team.get("third"));
                    aBundle.putString("url",(String)team.get("url"));
                    Log.d("AWAY: ", awayTeam.toString());
                }
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

    }

    private class myAdapt extends FragmentPagerAdapter
    {
        public  myAdapt(FragmentManager m){
            super(m);
        }

        @Override
        public Fragment getItem(int n){
            return bookViewPager.newInstance();
        }

        @Override
        public int getCount(){
            return 9;
        }

        @Override
        public void destroyItem(ViewGroup viewGroup, int poisition, Object object){

        }

    }

    public void loadTeam(Bundle b){
        getSupportFragmentManager().beginTransaction().replace(R.id.rosterHolder, rosterfragment.newInstance(b)).commit();
    }

    @Override
    public void onOutClick(){
        numOuts++;
        Log.d("outs: ", numOuts+"");
        if(numOuts == 3){
            Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_LONG).show();
            Log.d("GAME OVER", "gameover");
            homeScore.setVisibility(View.VISIBLE);
            awayScore.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(homeScore.getText().toString() == "" && awayScore.getText().toString() == "")
                        return;

                    hS = Integer.parseInt(homeScore.getText().toString());
                    aS = Integer.parseInt(awayScore.getText().toString());

                    if(hS>aS){
                        Bundle bundle = new Bundle();
                        bundle.putString("name", homeName);
                        dialogBox db = new dialogBox();
                        db.setArguments(bundle);
                        db.show(getFragmentManager(),"");
                        Toast.makeText(getApplicationContext(), "Home Team Wins", Toast.LENGTH_LONG).show();
                    }else if(aS>hS){
                        Bundle bundle = new Bundle();
                        bundle.putString("name", awayName);
                        dialogBox db = new dialogBox();
                        db.setArguments(bundle);
                        db.show(getFragmentManager(),"");
                        Toast.makeText(getApplicationContext(), "Away Team Wins", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}