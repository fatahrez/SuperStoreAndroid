package com.moringaschool.asuper.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.asuper.R;

import java.util.ArrayList;

public class ClerkAdapter extends RecyclerView.Adapter<ClerkAdapter.ClerkViewHolder> {
    private ArrayList<ClerkItem> mClerkList;

    public static class ClerkViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1, mTextView2;

        public ClerkViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image1);
            mTextView1 = itemView.findViewById(R.id.text1);
            mTextView2 = itemView.findViewById(R.id.text2);
        }
    }

    public ClerkAdapter (ArrayList<ClerkItem> clerkList) {
        mClerkList = clerkList;
    }
    @NonNull
    @Override
    public ClerkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clerk_item, parent, false);
       ClerkViewHolder cvh = new ClerkViewHolder(v);
       return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ClerkViewHolder holder, int position) {
        ClerkItem currentItem = mClerkList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mClerkList.size();
    }
}
