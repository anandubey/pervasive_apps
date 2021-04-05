package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText mRegNo = (EditText) findViewById(R.id.etLoginRegNo);
        final EditText mPass = (EditText) findViewById(R.id.etLoginPass);
        Button mBtnLogin = (Button) findViewById(R.id.LoginBtn);
        Button mBtnReg = (Button) findViewById(R.id.RegBtn);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regNo = mRegNo.getText().toString();
                String pass = mPass.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String userDetails = preferences.getString(regNo + pass + "data", "Reg No or Password is Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userDetails);
                editor.commit();

                Intent displayScreen = new Intent(MainActivity.this, DisplayScreen.class);
                startActivity(displayScreen);
            }
        });

        mBtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regScreen = new Intent(MainActivity.this, Register.class);
                startActivity(regScreen);
            }
        });
    }
}