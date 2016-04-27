package com.example.liam.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AppActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
private Toolbar toolbar;
private NavigationView navigationView;
private DrawerLayout drawerLayout;

        //  private Firebase firebaseRef = new Firebase("https://cis400hw9.firebaseio.com/");

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.drawer_layout);

            toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);

            navigationView = (NavigationView) findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(this);

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle actionBarDrawerToggle =
                    new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_closed) {
                        public void onDrawerClosed(View view) {
                            super.onDrawerClosed(view);
                        }
                        public void onDrawerOpened(View drawerView) {
                            super.onDrawerOpened(drawerView);
                        }
                    };

            drawerLayout.addDrawerListener(actionBarDrawerToggle);

            actionBarDrawerToggle.syncState();
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.holder, recycler_view.newInstance()).commit();
        }
        */
        }

        public boolean onNavigationItemSelected(MenuItem item)
        {
            int id = item.getItemId();

            switch(id){
                case R.id.playBallItem:
                    Toast.makeText(getApplicationContext(), "Clicked PlayBall Item", Toast.LENGTH_LONG).show();
                    break;
                case R.id.standingsItem:
                   // Toast.makeText(getApplicationContext(), "Clicked Book Item", Toast.LENGTH_LONG).show();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.holder, book.newInstance("")).addToBackStack(null).commit();
                    Intent intent = new Intent(this,BookActivity.class);
                    startActivity(intent);
                    break;
                case R.id.aboutUsItem:
                    Toast.makeText(getApplicationContext(), "Clicked AboutUS Item", Toast.LENGTH_LONG).show();
                    break;
                case R.id.createTeam:
                    Intent intent2 = new Intent(this,createActivity.class);
                    startActivity(intent2);
                    break;
                default:
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

}
