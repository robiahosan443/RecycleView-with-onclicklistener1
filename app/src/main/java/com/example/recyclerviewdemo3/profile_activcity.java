package com.example.recyclerviewdemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profile_activcity extends AppCompatActivity {

    TextView nametext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activcity);
        nametext=findViewById(R.id.nameTextView);

        String name="name not set yet";

        Bundle extras= getIntent().getExtras();
        if (extras!=null){

            name=extras.getString("username");
        }
        nametext.setText(name);
    }
}