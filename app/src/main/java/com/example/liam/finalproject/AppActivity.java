package com.example.liam.finalproject;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class AppActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Button viewLeague;
    Button playBall;


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

            viewLeague = (Button)findViewById(R.id.viewLeague);
            playBall = (Button)findViewById(R.id.playBall);

            viewLeague.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),BookActivity.class);
                    startActivity(intent);
                }
            });

            playBall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Clicked Play Ball Item", Toast.LENGTH_LONG).show();
                    Intent intentPlay = new Intent(getApplicationContext(),PlayActivity.class);
                    startActivity(intentPlay);
                }
            });


            TextView title = (TextView) findViewById(R.id.appTitle);
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/playball.ttf");
            title.setTypeface(tf);


        }

        public boolean onNavigationItemSelected(MenuItem item)
        {
            int id = item.getItemId();

            switch(id){
                case R.id.aboutUsItem:
                    Toast.makeText(getApplicationContext(), "Clicked About Us Item", Toast.LENGTH_LONG).show();
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.bounce, R.anim.slide_out_right).replace(R.id.drawer_layout, AboutUs.newInstance()).addToBackStack(null).commit();
                    break;
                case R.id.createTeam:
                    Intent intent2 = new Intent(this,createActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.logOut:
                    logOutDialog db = new logOutDialog();
                    db.show(getFragmentManager(), "");
                default:
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
}
