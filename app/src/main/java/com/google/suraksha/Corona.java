package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Corona extends AppCompatActivity implements View.OnClickListener {
    Button click;
    ImageButton toLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona);
        click = findViewById(R.id.button7);
        click.setOnClickListener(this);
        toLogin = findViewById(R.id.forward);
        toLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button7:
                Intent calling = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbc.com/hindi/science-51366908"));
                startActivity(calling);
                break;

            case R.id.forward :
                Intent up = new Intent(this,Login.class);
                startActivity(up);
                break;

        }

    }
}

