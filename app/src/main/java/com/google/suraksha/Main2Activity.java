package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Button submit,cancel;
    EditText name,contact,age;
    String nam,agee,ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spin=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.bloodgrp,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
        submit=findViewById(R.id.btsub);
        submit.setOnClickListener(this);
        cancel=findViewById(R.id.btcancel);
        cancel.setOnClickListener(this);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        age = findViewById(R.id.age);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        nam = name.getText().toString();
        agee = age.getText().toString();
        ph = contact.getText().toString();
        switch(v.getId()){
            case R.id.btsub :
                 if(nam.equals("")||agee.equals("")||ph.equals("")){
                     Toast.makeText(this,"Please fill the empty fields",Toast.LENGTH_SHORT).show();
               }
                 else{
                     Intent wait=new Intent(this,WaitPg.class);
                     startActivity(wait);
                 }
                 break;
            case R.id.btcancel:{
                Intent back=new Intent(this,HospitalPage.class);
                startActivity(back);
                break;
            }
        }
    }
}