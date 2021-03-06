package com.example.navigationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView rvCourses;
    ArrayList<Course> courseList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        MainActivity.generateCourses(courseList);
        rvCourses = (RecyclerView) findViewById(R.id.rvCourses);

        CourseRecyclerAdapter courseAdapter = new CourseRecyclerAdapter(
                this,
                courseList
        );
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(courseAdapter);
    }
}


