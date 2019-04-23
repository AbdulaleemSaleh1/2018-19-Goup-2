package com.example.timetableapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MapPage extends AppCompatActivity {
    private static final String TAG = "MapPage";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);

        Log.d(TAG, "OnCreate: started.");
        ImageView Secondimage = (ImageView)findViewById(R.id.Secondimage);
        int imageResource = getResources().getIdentifier("@drawable/brunelcampus", null, this.getPackageName());
        Secondimage.setImageResource(imageResource);
    }
    public void HomePG(View v){
        Intent myIntent = new Intent(getBaseContext(),   TimeTablePage.class);
        startActivity(myIntent);
    }
    public void InfoPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   InfoPage.class);
        startActivity(myIntent);
    }
    public void MapPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }

    public void account_Btn(View v) {
        Intent myIntent = new Intent(getBaseContext(), AccountPage.class);
        startActivity(myIntent);
    }

    public void GoogleMap(View v){
        Intent myIntent = new Intent(getBaseContext(),  GoogleMapsActivity.class);
        startActivity(myIntent);
    }
}
