package com.example.timetableapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);
    }
    public void HomePG(View v){
        Intent myIntent = new Intent(getBaseContext(),   TimeTablePage.class);
        startActivity(myIntent);
    }
    public void InfoPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   InfoPage.class);
        startActivity(myIntent);
    }

    public void account_Btn(View v) {
        Intent myIntent = new Intent(getBaseContext(), AccountPage.class);
        startActivity(myIntent);
    }
}
