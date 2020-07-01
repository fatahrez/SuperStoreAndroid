package com.moringaschool.asuper.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

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
import com.moringaschool.asuper.report.ReportsActivity;


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

        mNavigation = findViewById(R.id.navigationView);
        drawerLayout= findViewById(R.id.drawerLayout);
        mImage= findViewById(R.id.menuImg);
        mReports= findViewById(R.id.reports);
        mSales= findViewById(R.id.sales);
        mProducts= findViewById(R.id.products);
        mClerks= findViewById(R.id.clerks);


        mImage.setOnClickListener(this);
        mReports.setOnClickListener(this);
        mSales.setOnClickListener(this);
        mProducts.setOnClickListener(this);
        mClerks.setOnClickListener(this);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(mNavigation, navController);

        }

    @Override
    public void onClick(View v) {
        if (v == mClerks) {
            Intent intent = new Intent(AdminActivity.this, Adding.class);
            startActivity(intent);
        }
        if (v == mReports) {
            Intent intent = new Intent(AdminActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
    }
}
