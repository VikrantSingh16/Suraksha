package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HospitalPage extends AppCompatActivity implements View.OnClickListener {

    ImageButton paras;
    ImageButton ford;
    ImageButton vedanta;
    ImageButton igms;
    ImageButton aiims;
    ImageButton nalanda;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_page);
        paras = findViewById(R.id.bip);
        paras.setOnClickListener(this);
        ford = findViewById(R.id.bip2);
        ford.setOnClickListener(this);
        vedanta = findViewById(R.id.bip3);
        vedanta.setOnClickListener(this);
        igms = findViewById(R.id.bip4);
        igms.setOnClickListener(this);
        aiims = findViewById(R.id.bip5);
        aiims.setOnClickListener(this);
        nalanda = findViewById(R.id.bip6);
        nalanda.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bip :
                Intent hospInfo = new Intent(this,HospitalInfo.class);
                startActivity(hospInfo);
            break;
            case R.id.bip2 :
                Intent hospInfo2 = new Intent(this,HospitalInfo2.class);
                startActivity(hospInfo2);
                break;
            case R.id.bip3 :
                Intent hospInfo3 = new Intent(this,HospitalInfo3.class);
                startActivity(hospInfo3);
                break;
            case R.id.bip4 :
                Intent hospInfo4 = new Intent(this,HospitalInfo4.class);
                startActivity(hospInfo4);
                break;
            case R.id.bip5 :
                Intent hospInfo5 = new Intent(this,HospitalInfo5.class);
                startActivity(hospInfo5);
                break;
            case R.id.bip6 :
                Intent hospInfo6 = new Intent(this,HospitalInfo6.class);
                startActivity(hospInfo6);
                break;



        }



    }

}