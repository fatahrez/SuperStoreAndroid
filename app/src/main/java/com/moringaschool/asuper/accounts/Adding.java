package com.moringaschool.asuper.accounts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.moringaschool.asuper.R;
import com.moringaschool.asuper.models.ClerkAdapter;
import com.moringaschool.asuper.models.ClerkItem;

import java.util.ArrayList;

public class Adding extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        ArrayList<ClerkItem> clerkList = new ArrayList<>();
        clerkList.add(new ClerkItem(R.drawable.professionals, "Shop 1", "Clerk 1"));
        clerkList.add(new ClerkItem(R.drawable.teacher, "Shop 2", "Clerk 2"));
        clerkList.add(new ClerkItem(R.drawable.woman, "Shop 3", "Clerk 3"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ClerkAdapter(clerkList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {

    }
}