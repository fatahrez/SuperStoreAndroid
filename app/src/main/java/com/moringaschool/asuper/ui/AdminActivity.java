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

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import com.moringaschool.asuper.R;
import com.moringaschool.asuper.accounts.Adding;


public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mImage;
    NavigationView mNavigation;
    DrawerLayout drawerLayout;
    MaterialCardView mReports, mSales, mProducts, mClerks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin);

        drawerLayout= findViewById(R.id.drawerLayout);
        mImage= findViewById(R.id.menuImg);
        mImage.setOnClickListener(this);
        mReports.setOnClickListener(this);
        mSales.setOnClickListener(this);
        mProducts.setOnClickListener(this);
        mClerks.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);

        if (v == mClerks) {
            Intent intent = new Intent(AdminActivity.this, Adding.class);
            startActivity(intent);
        }
    }
}
