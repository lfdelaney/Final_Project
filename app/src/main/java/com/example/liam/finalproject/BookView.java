package com.example.liam.finalproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;

public class BookView extends AppCompatActivity implements bookViewPager.OnFragmentInteractionListener {

    private Firebase mRef = new Firebase("https://diamond-tracker.firebaseio.com/League");
    String homeName, awayName;
    HashMap<String, ?>homeTeam, awayTeam;
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


        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                HashMap<String, ?> team = (HashMap<String, ?>) dataSnapshot.getValue();

                if (homeName.equalsIgnoreCase((String) team.get("name"))) {
                    homeTeam = team;
                    Log.d("HOME: ", homeTeam.toString());
                }
                if (awayName.equalsIgnoreCase((String) team.get("name"))) {
                    awayTeam = team;
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

        //Log.d("HOME: ", homeTeam.toString());
        //Log.d("AWAY: ",awayTeam.toString());


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

    }

    @Override
    public void onImageButtonClicked(){

    }
}
