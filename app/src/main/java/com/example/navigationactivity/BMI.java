package com.example.navigationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {
    private EditText et1,et2;
    private Button btn;
    private TextView tv_result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        et1 = (EditText)findViewById(R.id.et_weight);
        et2 = (EditText)findViewById(R.id.et_height);
        tv_result =(TextView) findViewById(R.id.tv_result);
        btn =(Button)findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });
    }
    private void bmi(){
        float a,b,c;
        a=Float.parseFloat(et2.getText().toString())/100;
        b=Float.parseFloat(et1.getText().toString());
        c=b/(a*a);
        tv_result.setText(""+c);
        if(c <18.8){
            Toast.makeText(getApplicationContext(),"You are Underweight",Toast.LENGTH_SHORT);
            System.out.println("You are Underweight");
        }
        else if((c >=18.8) && (c<25)){
            Toast.makeText(getApplicationContext(),"You are FIT",Toast.LENGTH_LONG);
            System.out.println("You are FIT");
        }
        else if((c >=25) && (c<30)){
            Toast.makeText(getApplicationContext(),"You are OVERWEIGHT",Toast.LENGTH_LONG);
            System.out.println("You are OVERWEIGHT");
        }
        else if(c >30){
            Toast.makeText(getApplicationContext(),"You are Severly Obese",Toast.LENGTH_LONG);
            System.out.println("You are Severly Obese");
        }
    }
}
