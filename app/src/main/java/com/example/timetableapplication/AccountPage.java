package com.example.timetableapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccountPage extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        getUserDetailsAndAssign();
    }

    public void account_Btn(View v){
        Intent myIntent = new Intent(getBaseContext(),   AccountPage.class);
        startActivity(myIntent);
    }

    public void MapPG(View v){
        Intent myIntent = new Intent(getBaseContext(),   MapPage.class);
        startActivity(myIntent);
    }
    public void HomePG(View v){
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        getUserDetailsAndNavigate();
    }
    public void InfoPG(View v) {
        Intent myIntent = new Intent(getBaseContext(), InfoPage.class);
        startActivity(myIntent);
    }
    public void LogOut(){
        firebaseAuth.signOut();
        Intent intent = new Intent(AccountPage.this, MainActivity.class);
    }

    private void getUserDetailsAndNavigate() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                Intent intent = new Intent(AccountPage.this, TimeTablePage.class);
                intent.putExtra("userInfo",currentUser);
                startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    private void getUserDetailsAndAssign() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                TextView ID_Data = findViewById(R.id.IDInfo);
                String UserID =  currentUser.getStudentID();
                ID_Data.setText(UserID);
                TextView NameData = findViewById(R.id.NameInfo);
                String Name =  currentUser.getName();
                NameData.setText(Name);
                TextView Course_Data = findViewById(R.id.Course_Data);
                String Course =  currentUser.getCourse();
                Course_Data.setText(Course);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
