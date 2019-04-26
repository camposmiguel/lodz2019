package com.miguelcr.a01_tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAppName = findViewById(R.id.textViewAppName);

        // Change the font type
        Typeface type = Typeface.createFromAsset(
                getAssets(),
                "vegan.ttf");
        tvAppName.setTypeface(type);
    }

    public void startGame(View view) {
        // Navigate to the GameActivity
        Intent i = new Intent(
                MainActivity.this, GameActivity.class);
        startActivity(i);
    }
}
