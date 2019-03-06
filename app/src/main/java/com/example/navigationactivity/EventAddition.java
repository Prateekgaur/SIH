package com.example.navigationactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class EventAddition extends AppCompatActivity {
    EditText edit1, edit2, edit3;
    Button btnAdd;
    RecyclerView rvmealList;
    ArrayList<Course> mealList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_addition);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        btnAdd = (Button) findViewById(R.id.btn1);
        rvmealList = (RecyclerView) findViewById(R.id.rvCourses);

        Button b = (Button) findViewById(R.id.btn1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        /*mealList = Course.getCourses(6);


        final CourseRecyclerAdapter adapter = new CourseRecyclerAdapter(this,mealList);
        rvmealList.setLayoutManager(new LinearLayoutManager(this));
        rvmealList.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkMeal = edit1.getText().toString();
                String checkProtein = edit2.getText().toString();
                String checkCarbs = edit3.getText().toString();
                if(TextUtils.isEmpty(checkMeal)||TextUtils.isEmpty(checkProtein)||TextUtils.isEmpty(checkCarbs)){
                    Toast.makeText(getApplicationContext(), "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Course newCourse = new Course(
                        checkMeal,
                        checkProtein,
                        checkCarbs
                );
                mealList.add(newCourse);
                adapter.notifyDataSetChanged();
            }
        });

    */
    }
}


