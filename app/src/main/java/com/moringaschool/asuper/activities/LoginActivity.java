package com.moringaschool.asuper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.asuper.R;
import com.moringaschool.asuper.api.RetrofitClient;
import com.moringaschool.asuper.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText Email_l;
    private EditText password_l;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email_l = findViewById(R.id.Email_l);
        password_l = findViewById(R.id.password_l);

        findViewById(R.id.loginBtn_l).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.createText_l).setOnClickListener((View.OnClickListener) this);
    }

    private void userLogin(){

        String Email = Email_l.getText().toString().trim();
        String Password = password_l.getText().toString().trim();

        if (Email.isEmpty()) {
            Email_l.setError("Email is required");
            Email_l.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            Email_l.setError("Enter a valid email");
            Email_l.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            password_l.setError("Password is required");
            password_l.requestFocus();
            return;
        }

        if (Password.length() < 8) {
            password_l.setError("Password should be atleast 6 character long");
            password_l.requestFocus();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance().getSuperApi().userLogin(Email,Password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (!loginResponse.isError()){

                    // proceed with login through the following ways
                    // save user
                    // open profile

                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }


//    @Override
//    public void onClick
//            (View v){
//        switch (v.getId()){
//            case R.id.btn_login:
//                userLogin();
//                break;
//            case R.id.createText_l:
//                startActivity(new Intent(this, RegisterActivity.class));
//                break;
//        }
    }


