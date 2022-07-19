package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = findViewById(R.id.edittext);
        e2 = findViewById(R.id.edittext2);
        b1 = findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Login.this, Register.class);
                startActivity(j);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();

                Boolean chkemailpass = db.emailpassword(email, password);
                if (chkemailpass == true) {
                    Intent i = new Intent(Login.this, HospitalPage.class);
                    startActivity(i);


                    Toast.makeText(getApplicationContext(), "Successfully Logged in ", Toast.LENGTH_LONG).show();
                }


                else{
                        Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }
}