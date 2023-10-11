package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button startbtn,holdbtn,resetbtn,lapbtn;
    TextView laps_show;
    Chronometer chronometer;
    long stopTime=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn= findViewById(R.id.startBtn);
        holdbtn = findViewById(R.id.holdBtn);
        resetbtn= findViewById(R.id.reset_btn);
        lapbtn= findViewById(R.id.lap_btn);
        laps_show= findViewById(R.id.tv_lap);
        chronometer= findViewById(R.id.Chronometer);

        startbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime()+stopTime);
                chronometer.start();
                startbtn.setVisibility(View.GONE);
                holdbtn.setVisibility(View.VISIBLE);
            }
        });

        holdbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopTime=chronometer.getBase()-SystemClock.elapsedRealtime();
                chronometer.stop();
                startbtn.setVisibility(View.VISIBLE);
                holdbtn.setVisibility(View.GONE);
            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                stopTime=0;
                chronometer.stop();
                startbtn.setVisibility(View.VISIBLE);
                holdbtn.setVisibility(View.GONE);
            }
        });

        lapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strlap=chronometer.getText().toString();
                laps_show.setText(strlap);
            }
        });


    }

}