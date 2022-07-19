package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper db;

    EditText e1,e2,e3,e4;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        e1=findViewById(R.id.email);
        e2 = findViewById(R.id.pass);
        e3 = findViewById(R.id.cpass);
        e4=findViewById(R.id.name);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this,Login.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                if(s1.equals("")||s2.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_SHORT).show();

                }
                else if(!s2.equals(s3)){

                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkemail=db.chkemail(s1);
                        if(chkemail==true) {
                            Boolean insert = db.insert(s1,s2);
                            if (insert == true) {

                                Intent i = new Intent(Register.this, Login.class);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(), "Registered Succesfully. Welcome to Suraksha "+s4, Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Something went wrong try again later",Toast.LENGTH_LONG).show();
                            }

                        }




                        else {
                            Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_SHORT).show();

                        }

                    }
                }

            }
        });
//        Cursor cursor = db.alldata();
//        if(cursor.getCount()==0){
//            Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_LONG).show();
//
//        }
//        else{
//            while(cursor.moveToNext()){
//                Toast.makeText(getApplicationContext(),"Email ID: "+cursor.getString(0),Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),"Password: "+cursor.getString(1),Toast.LENGTH_LONG).show();
//
//
//            }

    }
}