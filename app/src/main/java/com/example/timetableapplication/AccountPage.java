package com.example.timetableapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AccountPage extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
    public void MapPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }
    public void HomePG(View v){
        Intent myIntent = new Intent(getBaseContext(),   TimeTablePage.class);
        startActivity(myIntent);
    }
    public void InfoPG(View v){
        Intent myIntent = new Intent(getBaseContext(),  InfoPage.class);
        startActivity(myIntent);
    }
}
