package com.example.timetableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Name = (EditText)findViewById(R.id.UsernameText);
        Password = (EditText)findViewById(R.id.PasswordText);
        Login = (Button)findViewById(R.id.LoginButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, TimeTablePage.class);
            startActivity(intent);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng Brunel = new LatLng(51.53252706501752,-0.48024521922898716);
        map.addMarker(new MarkerOptions().getPosition(Brunel).title("Brunel"));
    map.moveCamera(CameraUpdateFactory.newLatLng(Brunel));
    }
}
