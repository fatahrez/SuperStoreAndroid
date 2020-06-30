package com.moringaschool.asuper.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.asuper.R;

public class Signup extends AppCompatActivity {

    EditText mFirstName, mUserName, mEmail, mPassword;
    Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirstName= findViewById(R.id.name);
        mUserName= findViewById(R.id.username);
        mEmail = findViewById(R.id.textEmailAddress);
        mPassword = findViewById(R.id.textPassword);
        mSignUp = findViewById(R.id.signup);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String firstName = mFirstName.getText().toString();
                String username = mUserName.getText().toString();
                Intent intent = new Intent(Signup.this, AdminActivity.class);
                intent.putExtra("email", emailAddress);
                intent.putExtra("password", password);
                intent.putExtra("firstName", firstName);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

    }
}