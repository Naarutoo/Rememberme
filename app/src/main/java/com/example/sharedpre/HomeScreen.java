package com.example.sharedpre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
private TextView mtvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mtvUsername = findViewById(R.id.tvUsername);
        String name = PreferenceHelper.getStringfromPrefernce(HomeScreen.this,"username");
        mtvUsername.setText(name);
    }
}