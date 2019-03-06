package com.example.navigationactivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
public class Dieto extends AppCompatActivity implements View.OnClickListener{

    private int notificationId = 1;
    Spinner spin;
    TextView editText;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dieto);
        spin = (Spinner) findViewById(R.id.spin);
        editText = (TextView) findViewById(R.id.textview);

        String [] nutrients = {"Corn Flakes","Rice"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nutrients);
        spin.setAdapter(adapter);


        // Set Onclick Listener.
        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String selectedItem = (String) arg0.getSelectedItem();
                if(selectedItem.trim().equals("Corn Flakes")){
                    editText.setText(Float.toString(220) + "gm");
                }else if(selectedItem.trim().equals("Rice")){
                    editText.setText(Float.toString(170) + "gm");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
    @Override
    public void onClick(View view) {
        timePicker = (TimePicker) findViewById(R.id.timePicker);


        // Set notificationId & text.
        Intent intent = new Intent(Dieto.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("name", spin.getSelectedItem().toString());
        intent.putExtra("todo", editText.getText().toString());



        // getBroadcast(context, requestCode, intent, flags)
        PendingIntent alarmIntent = PendingIntent.getBroadcast(Dieto.this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId()) {

            case R.id.setBtn:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();



                // Create time.
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                // Set alarm.
                // set(type, milliseconds, intent)
                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "Canceled.", Toast.LENGTH_SHORT).show();
                break;
        }


    }

}
