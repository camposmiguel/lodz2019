package com.miguelcr.a02_duckhuntgame;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvCounter, tvTimer, tvNick;
    ImageView ivDuck;
    int ducksHunted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get the reference to the View components
        tvCounter = findViewById(R.id.textViewCounter);
        tvTimer = findViewById(R.id.textViewTimer);
        tvNick = findViewById(R.id.textViewNick);
        ivDuck = findViewById(R.id.imageViewDuck);

        // duck >>> click event
        ivDuck.setOnClickListener(this);

        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View v) {
        // Increase the number of ducks hunted.
        ducksHunted++;
        
        // move the duck to a different position
        moveDuckRandom();
    }

    private void moveDuckRandom() {
        // Get the screen width and height
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.i("POS", "Screen:" + width + "," + height);

        // Generate a random X,Y position for the duck
        int minimum = 0;
        int maximumX = width - ivDuck.getWidth(); // screen width
        int maximumY = height - ivDuck.getHeight(); // screen height

        Random rand = new Random();
        int randomX = rand.nextInt((maximumX - minimum) + 1);
        int randomY = rand.nextInt((maximumY - minimum) + 1);
        Log.i("POS", "X:" + randomX);
        Log.i("POS", "Y:" + randomY);

        // Apply the random position to the duck ImageView
        ivDuck.setX(randomX);
        ivDuck.setY(randomY);
    }
}
