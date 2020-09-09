package com.example.recyclerviewdemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User>userlist;
    private RecyclerView recyclerView;
    private RecyclerAdapter.RecycleViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerviewId);

        userlist=new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOncliclListener();
        RecyclerAdapter adapter= new RecyclerAdapter(userlist,listener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOncliclListener() {

        listener= new RecyclerAdapter.RecycleViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent =new Intent(getApplicationContext(),profile_activcity.class);
                intent.putExtra("username",userlist.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {

        userlist.add(new User("jhon"));
        userlist.add(new User("jhon1"));
        userlist.add(new User("jhon2"));
        userlist.add(new User("jhon3"));
    }
}