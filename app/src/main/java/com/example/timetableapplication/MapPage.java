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
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }
    public void InfoPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   InfoPage.class);
        startActivity(myIntent);
    }
<<<<<<< HEAD
<<<<<<< HEAD

    public void account_Btn(View v) {
        Intent myIntent = new Intent(getBaseContext(), AccountPage.class);
=======
    public void TimeTablePG(View v){
        Intent myIntent = new Intent(getBaseContext(),  TimeTablePage.class);
>>>>>>> 37f7dc968155e366ea1c4e7e83e2c962166fb6d9
=======
    public void TimeTablePG(View v){
        Intent myIntent = new Intent(getBaseContext(),  TimeTablePage.class);
>>>>>>> parent of 1533920... Finalised template to homePG and MapPG
        startActivity(myIntent);
    }
}
