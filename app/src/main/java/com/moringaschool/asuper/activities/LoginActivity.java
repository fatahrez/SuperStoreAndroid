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
import com.moringaschool.asuper.ui.ClerkActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail_l;
    private EditText editTextpassword_l;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail_l = findViewById(R.id.Email_l);
        editTextpassword_l = findViewById(R.id.password_l);

        findViewById(R.id.loginBtn_l).setOnClickListener((View.OnClickListener) this);
        findViewById(R.id.createText_l).setOnClickListener((View.OnClickListener) this);
    }

    private void userLogin(){

        String Email = editTextEmail_l.getText().toString().trim();
        String Password = editTextpassword_l.getText().toString().trim();

        if (Email.isEmpty()) {
            editTextEmail_l.setError("Email is required");
            editTextEmail_l.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            editTextEmail_l.setError("Enter a valid email");
            editTextEmail_l.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            editTextpassword_l.setError("Password is required");
            editTextpassword_l.requestFocus();
            return;
        }

        if (Password.length() < 8) {
            editTextpassword_l.setError("Password should be atleast 6 character long");
            editTextpassword_l.requestFocus();
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

    @Override

    public void onClick
            (View v){
        switch (v.getId()){
            case R.id.loginBtn_l:
                userLogin();
                startActivity(new Intent(this, ClerkActivity.class));
                break;
            case R.id.createText_l:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}


