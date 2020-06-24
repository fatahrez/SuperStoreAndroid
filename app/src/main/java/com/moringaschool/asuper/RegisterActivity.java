package com.moringaschool.asuper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.moringaschool.asuper.ui.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

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

        findViewById(R.id.registration).setOnClickListener(this);
        findViewById(R.id.createText).setOnClickListener(this);
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

            /* Do user registration using the api call*/

        Call<ResponseBody> call = RetrofitClient
                .getInstance()
                .getSuperApi()
                .createClerk(Email, Password, UserName, FirstName, LastName);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String s = null;

                try {
                    if (response.code() == 201) {
                        s = response.body().string();
                    } else {
                        s = response.errorBody().string();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (s != null){
                    try{
                        JSONObject jsonObject = new JSONObject(s);
                        Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        }

        @Override
        public void onClick; (View v){
            switch (v.getId()) {
                case R.id.registration:

                    break;
                case R.id.createText:

                    break;
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registration:

                break;
            case R.id.createText:

                break;
        }
    }
}
