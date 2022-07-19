package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BookedSuces extends AppCompatActivity implements View.OnClickListener {
    TextView rndmid;
    Button backtohospitallist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_suces);
         backtohospitallist=findViewById(R.id.button9);
         backtohospitallist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent nextoq= new Intent(this,HospitalPage.class);
        startActivity(nextoq);
    }
}