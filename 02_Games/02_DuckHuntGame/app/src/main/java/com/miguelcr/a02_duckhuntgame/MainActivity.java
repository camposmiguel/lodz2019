package com.miguelcr.a02_duckhuntgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNick;
    Button btnStart, btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNick = findViewById(R.id.editTextNick);
        btnStart = findViewById(R.id.buttonStartGame);
        btnRanking = findViewById(R.id.buttonRanking);

        // Button >>> click event (start game)
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the GameActivity
                Intent i = new Intent(MainActivity.this, GameActivity.class);

                // Send data to the GameActivity
                // var > nickname, value > etNick.getText().toString()
                i.putExtra("nickname", etNick.getText().toString());

                startActivity(i);
            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RankingActivity.class);
                startActivity(i);
            }
        });
    }
}
