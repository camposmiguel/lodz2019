package com.miguelcr.a03_glideexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView ivHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHotel = findViewById(R.id.imageViewHotel);

        Glide.with(this)
                .load("https://www.phocuswire.com/uploadedImages/News/Distribution/airbnb-hotels-one-year.png")
                .centerCrop()
                .into(ivHotel);
    }
}
