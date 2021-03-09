package com.example.a253app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView isCorrectTextView;
    EditText loginEditText, passwordEditText;
    Resources res;

    private static final String LOGIN = "login", PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);
        isCorrectTextView = (TextView)findViewById(R.id.isCorrectTextView);
        loginEditText = (EditText)findViewById(R.id.loginEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        res = getResources();
    }
    public void onClick(View view) {
        int acceptedColor = res.getColor(R.color.accepted, null);
        int declinedColor = res.getColor(R.color.declined, null);
        if (loginEditText.getText().toString().equals(LOGIN) &&
                passwordEditText.getText().toString().equals(PASSWORD)) {
            isCorrectTextView.setBackgroundColor(acceptedColor);
            isCorrectTextView.setText("Правильный пароль");
        }
        else {
            isCorrectTextView.setBackgroundColor(declinedColor);
            isCorrectTextView.setText("Неправильный пароль");
            Intent i = new Intent(this, RegistrationActivity.class);
            startActivityForResult(i, 1);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            loginEditText.setText(data.getStringExtra("login"));
        }
        else {
            loginEditText.setText("");
        }
        passwordEditText.setText("");
    }

}