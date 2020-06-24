package com.moringaschool.asuper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.moringaschool.asuper.R;


public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mImage;
    NavigationView mNavigation;
    DrawerLayout drawerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin);

        drawerLayout= findViewById(R.id.drawerLayout);
        mImage= findViewById(R.id.menuImg);
        mImage.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);

    }
}
