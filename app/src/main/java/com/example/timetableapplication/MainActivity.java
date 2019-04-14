package com.example.timetableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends FragmentActivity {


    private EditText email, password;
    private TextView Info;
    private Button Login;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: started.");
        ImageView Firstimage = (ImageView)findViewById(R.id.Firstimage);
        int imageResource = getResources().getIdentifier("@drawable/brunellogo", null, this.getPackageName());
        Firstimage.setImageResource(imageResource);

        FirebaseApp.initializeApp(this);
        email = (EditText)findViewById(R.id.UsernameText);
        password = (EditText)findViewById(R.id.PasswordText);
        Login = (Button)findViewById(R.id.LoginButton);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        email.setText("1613928@brunel.ac.uk");
        password.setText("password123");

        if(firebaseUser != null) {

            getUserDetailsAndNavigate();

        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void validate(String email, String userPassword) {
        if(email.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(this, "Enter Both Fields", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email,userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        getUserDetailsAndNavigate();
                    } else {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
    }

    private void getUserDetailsAndNavigate() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);
                Intent intent = new Intent(MainActivity.this, TimeTablePage.class);
                intent.putExtra("userInfo",currentUser);
                startActivity(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
