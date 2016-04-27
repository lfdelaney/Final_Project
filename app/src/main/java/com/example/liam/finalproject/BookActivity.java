package com.example.liam.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class BookActivity extends AppCompatActivity implements recyclerview.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.myholder, recyclerview.newInstance()).commit();
        }
    }

    @Override
    public void onListItemSelected(int x, HashMap<String, ?> book)
    {
        //stateListDrawable.addState(new int[]{ android.R.attr.state_pressed }, R.drawable.card_shape_pressed);
    }



}
