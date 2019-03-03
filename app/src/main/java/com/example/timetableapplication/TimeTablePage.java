package com.example.timetableapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TimeTablePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_page);

    }
    public void MapBtnClick(View v){
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }
    public void InfoBtnClick(View v){
        Intent myIntent = new Intent(getBaseContext(),  InfoPage.class);
        startActivity(myIntent);
    }
}
