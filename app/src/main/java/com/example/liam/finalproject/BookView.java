package com.example.liam.finalproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BookView extends AppCompatActivity implements bookViewPager.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.pager, bookViewPager.newInstance()).commit();
        }

        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(new myAdapt(getSupportFragmentManager()));

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
