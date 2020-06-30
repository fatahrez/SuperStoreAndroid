package com.moringaschool.asuper.ui;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.asuper.ServiceGenerator;
import com.moringaschool.asuper.SuperApi;
import com.moringaschool.asuper.models.Admin;
import com.moringaschool.asuper.models.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.moringaschool.asuper.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    //Variables
    Button signUp;
    Button login;
    EditText mEmail, mPassword;

    //Retrofit
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api-shop-url.herokuapp.com/login/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    SuperApi api = retrofit.create(SuperApi.class);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.signUp);
        login = findViewById(R.id.login);
        mEmail = findViewById(R.id.emailAddress);
        mPassword = findViewById(R.id.password);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginActivity.this, Signup.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                intent.putExtra("email", emailAddress);
                intent.putExtra("password", password);
                startActivity(intent);
                finish();
            }
        });
    }
}