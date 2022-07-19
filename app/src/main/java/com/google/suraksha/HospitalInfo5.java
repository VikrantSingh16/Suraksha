package com.google.suraksha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.Request.*;

public class HospitalInfo5 extends AppCompatActivity implements View.OnClickListener {

    TextView hospiname,rating,call,patient,mortality;
    Button button,button2;


    String data = "";

    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_info5);
        button=findViewById(R.id.button5);
        button.setOnClickListener(this);
        button2=findViewById(R.id.button55);
        button2.setOnClickListener(this);
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        hospiname = findViewById(R.id.hnm5);
        rating = findViewById(R.id.rat5);
        call = findViewById(R.id.call5);
        patient = findViewById(R.id.pa5);
        mortality = findViewById(R.id.mr5);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://hospital-list.free.beeceptor.com/igms", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String NameOfHospital = response.getString("Name");
                    hospiname.setText(NameOfHospital);
                    String ratingOfHospital = response.getString("Rating");
                    rating.setText(ratingOfHospital);

                    String personAdmitted = response.getString("AP");
                    patient.setText(personAdmitted);

                    String mortalityRate = response.getString("MR");
                    mortality.setText(mortalityRate);

                    String helplineNumber = response.getString("Call");
                    call.setText(helplineNumber);


                    Log.d("myapp", "The response is" + response.getString("Name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong");

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button5:{

                Intent wait=new Intent(this,Main2Activity.class);
                startActivity(wait);
            }break;
            case R.id.button55:{
                Intent forward=new Intent(this,Feedback.class);
                startActivity(forward);
                break;
            }
        }
    }
}
