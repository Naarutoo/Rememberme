package com.example.sharedpre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText metUsername, metPassword;
private CheckBox mcbSave;
private Button mbtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        boolean value = PreferenceHelper.getBooleanfromPrefernce(MainActivity.this, "check");
        if (value == true) {
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);
        } else
        {
            mbtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  intent = new Intent(MainActivity.this,HomeScreen.class);

                    PreferenceHelper.writeStringTopreference(MainActivity.this,"username",metUsername.getText().toString());
                    startActivity(intent);
                }
            });
        }
        mcbSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    PreferenceHelper.writeBooleanTopreference(MainActivity.this,"check",true);
                    PreferenceHelper.writeStringTopreference(MainActivity.this,"username",metUsername.getText().toString());
                }
            }
        });

    }

    private void initview() {
    metUsername = findViewById(R.id.etUsername);
    metPassword = findViewById(R.id.etPassword);
    mcbSave = findViewById(R.id.btnCheckBox);
    mbtnLogin = findViewById(R.id.btnLogin);
    }
}