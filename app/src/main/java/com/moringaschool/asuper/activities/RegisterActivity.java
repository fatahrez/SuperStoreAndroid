package com.moringaschool.asuper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.asuper.api.ApiInstance;
import com.moringaschool.asuper.api.RetrofitClient;
import com.moringaschool.asuper.models.DefaultResponse;
import com.moringaschool.asuper.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText email, password, username, first_name, last_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);

        findViewById(R.id.registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.createText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void userSignUp() {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String UserName = username.getText().toString().trim();
        String FirstName = first_name.getText().toString().trim();
        String LastName = last_name.getText().toString().trim();

        if (Email.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (Password.length() < 8) {
            password.setError("Password should be atleast 6 character long");
            password.requestFocus();
            return;
        }

        if (UserName.isEmpty()) {
            username.setError("User Name is required");
            username.requestFocus();
            return;
        }

        if (FirstName.isEmpty()) {
            first_name.setError("First Name required");
            first_name.requestFocus();
            return;
        }

        if (LastName.isEmpty()) {
            last_name.setError("Last Name required");
            last_name.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getSuperApi()
                .createClerk(Email, Password, UserName, FirstName, LastName);

        call.enqueue(new Callback<DefaultResponse>() {
        @Override
        public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

            if (response.code() == 201) {

                DefaultResponse defaultResponse = response.body();
                Toast.makeText(RegisterActivity.this, defaultResponse.getMsg(), Toast.LENGTH_LONG).show();

            } else if (response.code() == 422) {
                Toast.makeText(RegisterActivity.this, "User already exist", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<DefaultResponse> call, Throwable t) {

        }
    });

        /* Do user registration using the api call*/

    }

//    @Override
//    public  void onClick(View v) {
//        switch (v.getId()){
//            case R.id.registration:
//                userSignUp();
//                break;
//            case R.id.createText:
//
//                break;
//        }



        // ApiInstance //

//            ApiInstance.store().createClerk
//                    (Email, Password, UserName , FirstName, LastName).enqueue(new Callback<DefaultResponse>() {
//                @Override
//                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<DefaultResponse> call, Throwable t) {
//
//                }
//            });


        }


