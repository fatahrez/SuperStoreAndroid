package com.moringaschool.asuper.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.moringaschool.asuper.R;

public class MainActivity extends AppCompatActivity {

    //Variables
    Animation topAnim;
    ImageView shop, checklist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
    }
}
