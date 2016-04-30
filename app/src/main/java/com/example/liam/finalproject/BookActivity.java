package com.example.liam.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookActivity extends AppCompatActivity implements recyclerview.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        setContentView(R.layout.activity_book);

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.myholder, recyclerview.newInstance()).commit();
        }

    }

    @Override
    public void onListItemSelected(int x,  Bundle b)
    {
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.bounce, R.anim.slide_out_right).replace(R.id.myholder, teamview.newInstance(x,b)).addToBackStack(null).commit();
    }

}
