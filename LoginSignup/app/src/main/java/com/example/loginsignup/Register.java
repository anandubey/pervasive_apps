package com.example.loginsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText mRegNo = (EditText) findViewById(R.id.etRegNo);
        final EditText mName = (EditText) findViewById(R.id.etName);
        final EditText mEmail = (EditText) findViewById(R.id.etEmail);
        final EditText mPassword = (EditText) findViewById(R.id.etPassword);
        Button mBtnRegister = (Button) findViewById(R.id.btnRegister);
        Button mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newRegNo = mRegNo.getText().toString();
                String newName = mName.getText().toString();
                String newEmail = mEmail.getText().toString();
                String newPassword = mPassword.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(newRegNo + newPassword + "data", newRegNo + '\n' + newName + '\n' + newEmail);
                editor.commit();

                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);

            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(loginScreen);
            }
        });
    }
}
