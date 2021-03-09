package com.example.a253app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText loginEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        loginEditText = (EditText)findViewById(R.id.loginEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
    }
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("login", loginEditText.getText().toString());
        setResult(RESULT_OK, i);
        finish();
    }
}