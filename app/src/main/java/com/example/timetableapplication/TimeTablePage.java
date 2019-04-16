package com.example.timetableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TimeTablePage extends AppCompatActivity {


    private DatabaseReference lectureReference;
    private ArrayList<Lecture> listOfLectures = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_page);

        Intent intent = getIntent();
        User currentUser = (User)intent.getExtras().get("userInfo");
//        Intent toAccountInfoIntent = new Intent(this, InfoPage.class);
//        toAccountInfoIntent.putExtra("userInfo", currentUser);
//        startActivity(toAccountInfoIntent);



        Toast.makeText(this, "Hi " + currentUser.getName(), Toast.LENGTH_SHORT).show();

        lectureReference = FirebaseDatabase.getInstance().getReference().child("Lectures");

        lectureReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for(DataSnapshot child: children) {

                    Lecture singleLecture = child.getValue(Lecture.class);
                    listOfLectures.add(singleLecture);

                }
                for(int i = 0; i < listOfLectures.size(); i++) {
                    Log.v("E_VALUE",listOfLectures.get(i).getModule());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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
   public void account_Btn(View v) {
       Intent myIntent = new Intent(getBaseContext(), AccountPage.class);
       startActivity(myIntent);
//    }
   }
}
