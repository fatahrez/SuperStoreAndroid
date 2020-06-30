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
import com.moringaschool.asuper.ui.ClerkActivity;
import com.moringaschool.asuper.ui.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextemail;
    private EditText editTextpassword;
    private EditText editTextusername;
    private EditText editTextfirst_name;
    private EditText editTextlast_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextemail = findViewById(R.id.email);
        editTextpassword = findViewById(R.id.password);
        editTextusername = findViewById(R.id.username);
        editTextfirst_name = findViewById(R.id.first_name);
        editTextlast_name = findViewById(R.id.last_name);

        findViewById(R.id.registration).setOnClickListener(this);
        findViewById(R.id.createText).setOnClickListener(this);

    }

    private void userSignUp() {
        String Email = editTextemail.getText().toString().trim();
        String Password = editTextpassword.getText().toString().trim();
        String UserName = editTextusername.getText().toString().trim();
        String FirstName = editTextfirst_name.getText().toString().trim();
        String LastName = editTextlast_name.getText().toString().trim();

        if (Email.isEmpty()) {
            editTextemail.setError("Email is required");
            editTextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            editTextemail.setError("Enter a valid email");
            editTextemail.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            editTextpassword.setError("Password is required");
            editTextpassword.requestFocus();
            return;
        }

        if (Password.length() < 8) {
            editTextpassword.setError("Password should be at least 8 character long");
            editTextpassword.requestFocus();
            return;
        }

        if (UserName.isEmpty()) {
            editTextusername.setError("User Name is required");
            editTextusername.requestFocus();
            return;
        }

        if (FirstName.isEmpty()) {
            editTextfirst_name.setError("First Name required");
            editTextfirst_name.requestFocus();
            return;
        }

        if (LastName.isEmpty()) {
            editTextlast_name.setError("Last Name required");
            editTextlast_name.requestFocus();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registration:
                userSignUp();
                break;
            case R.id.createText:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}


