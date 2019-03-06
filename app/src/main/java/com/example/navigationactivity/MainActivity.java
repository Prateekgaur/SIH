package com.example.navigationactivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Course> courseList = new ArrayList<>();
    ListView lvCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageview = (ImageView) findViewById(R.id.img);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EventAddition.class);
                startActivity(intent);
            }
        });

        generateCourses(courseList);
        lvCourses = (ListView) findViewById(R.id.lvCourses);

        CourseListAdapter courseListAdapter = new CourseListAdapter(this, courseList);
        lvCourses.setAdapter(courseListAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE",MODE_PRIVATE)
                .getBoolean("isfirstrun",true);
        if(isFirstRun){
            //do something
            Intent i5 = new Intent(getApplicationContext(),StartingPage.class);
            startActivity(i5);
            getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isfirstrun",false).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    static void generateCourses (ArrayList<Course> courses) {
        courses.add(new Course("SPORTZ-2019", "North Campus", "Cricket"));
        courses.add(new Course("Maharaja Agrasen Institute OF Technology ,Rohini sec 22,PSP Area,Plot No 1,New Delhi-110086", "Pitampura", "Kabbadi"));
        courses.add(new Course("Inter University Athletic Meet", "Ranibagh", "Badminton"));

        courses.add(new Course("Football Meet", "Delhi", "Football"));
        courses.add(new Course("TT Challenge", "Panipat", "Table Tenis"));
    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId() ;

        if (id == R.id.nav_login) {
            Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_slideshow) {
            Intent I = new Intent(getApplicationContext(),ProfileActivity.class);
            startActivity(I);

        }else if (id == R.id.nav_gallery) {
        Intent BMI = new Intent(getApplicationContext(),BMI.class);
        startActivity(BMI);
        }

        else if (id == R.id.nav_dieto) {

            Intent intent = new Intent(getApplicationContext(), Dieto.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
            Intent i6 = new Intent(getApplicationContext(),NewActivity.class);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
