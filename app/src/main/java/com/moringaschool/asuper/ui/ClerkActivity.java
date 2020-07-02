package com.moringaschool.asuper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.asuper.R;
import com.moringaschool.asuper.items.RecievedActivity;

public class ClerkActivity extends AppCompatActivity {

    private LinearLayout payments, recieved, supply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk);
        payments=findViewById(R.id.payments);
        recieved=findViewById(R.id.recieved);
        supply=findViewById(R.id.supply);

        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClerkActivity.this,"You have clicked payments", Toast.LENGTH_LONG).show();
            }
        });

        recieved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClerkActivity.this, RecievedActivity.class);
            }
        });

        supply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClerkActivity.this,"You have clicked on supply",Toast.LENGTH_LONG).show();
            }
        });
    }
}
