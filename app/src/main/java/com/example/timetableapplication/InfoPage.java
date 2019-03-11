package com.example.timetableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
    }
    public void MapPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }
    public void HomePG(View v){
        Intent myIntent = new Intent(getBaseContext(),   InfoPage.class);
        startActivity(myIntent);
    }
    public void TimeTablePG(View v){
        Intent myIntent = new Intent(getBaseContext(),  TimeTablePage.class);
        startActivity(myIntent);
    }
}
