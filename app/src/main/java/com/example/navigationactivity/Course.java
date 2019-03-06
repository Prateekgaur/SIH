package com.example.navigationactivity;

import java.util.ArrayList;
import java.util.Random;

public class Course {String name;
    String center;
    String classes;

    public Course(String name, String center, String classes) {
        this.name = name;
        this.center = center;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public String getCenter() {
        return center;
    }

    public String getClasses() {
        return classes;
    }
    static String meals[];
    static String proteins[];
    static String Carbos[];

    public static ArrayList<Course> getCourses(int n){
        ArrayList<Course> coursesList  = new ArrayList<>();
        Random r = new Random();

        for(int i = 0 ;i< n ;i++){
            Course newCourse = new Course(
                    meals[i],
                    proteins[i],
                    Carbos[i]

            );
            coursesList.add(newCourse);
        }

        return coursesList;

    }
}