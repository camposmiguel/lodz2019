package com.miguelcr.a02_duckhuntgame;

import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvCounter, tvTimer, tvNick;
    ImageView ivDuck;
    int ducksHunted = 0;
    boolean gameOver = false;
    String nick;

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

        getNick();
        startCountDown();

    }

    private void getNick() {
        Bundle extras = getIntent().getExtras();
        nick = extras.getString("nickname");
        tvNick.setText(nick);
    }

    private void startCountDown() {
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                tvTimer.setText("0s");
                gameOver = true;
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        if(gameOver) {
            Toast.makeText(this, "Game is over", Toast.LENGTH_SHORT).show();
        } else {
            // Increase the number of ducks hunted.
            ducksHunted++;

            // int > String
            tvCounter.setText(String.valueOf(ducksHunted));

            ivDuck.setImageResource(R.drawable.duck_clicked);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivDuck.setImageResource(R.drawable.duck);
                    // move the duck to a different position
                    moveDuckRandom();
                }
            }, 500);

        }

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
