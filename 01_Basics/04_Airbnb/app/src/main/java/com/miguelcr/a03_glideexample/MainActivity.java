package com.miguelcr.a03_glideexample;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView ivPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayer = findViewById(R.id.imageViewPlayer);

        Glide.with(this)
                .load("photo address....")
                .centerCrop()
                .into(ivPlayer);
    }
}
