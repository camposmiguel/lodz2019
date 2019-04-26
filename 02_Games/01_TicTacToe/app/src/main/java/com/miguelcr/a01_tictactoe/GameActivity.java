package com.miguelcr.a01_tictactoe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    boolean isPlayingOne = true;
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    /*
    *    0  | 1 |  2
    *   -------------
    *    3  | 4 |  5
    *   -------------
    *    6  | 7 |  8

    *   0 >>>> free
    *   1 >>>> player 1
    *   2 >>>> player 2
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void cellClicked(View view) {
        // Transform the generic View type to ImageView
        ImageView ivClicked = (ImageView) view;

        int positionClicked = 0;
        switch (ivClicked.getId()) {
            case R.id.imageView0: positionClicked = 0; break;
            case R.id.imageView1: positionClicked = 1; break;
            case R.id.imageView2: positionClicked = 2; break;
            case R.id.imageView3: positionClicked = 3; break;
            case R.id.imageView4: positionClicked = 4; break;
            case R.id.imageView5: positionClicked = 5; break;
            case R.id.imageView6: positionClicked = 6; break;
            case R.id.imageView7: positionClicked = 7; break;
            case R.id.imageView8: positionClicked = 8; break;
        }

        // Changing the image in the cell
        if(isPlayingOne) {
            if(selectedCells[positionClicked] == 0) { // free
                ivClicked.setImageResource(R.drawable.ic_player_one);
                selectedCells[positionClicked] = 1;
                if(existSolution()) {
                    Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
                } else {
                    // Change the player that is playing for the next time
                    isPlayingOne = !isPlayingOne;
                }
            } else {
                Toast.makeText(this, "Select another cell", Toast.LENGTH_SHORT).show();
            }
        } else {
            if(selectedCells[positionClicked] == 0) { // free
                ivClicked.setImageResource(R.drawable.ic_player_two);
                selectedCells[positionClicked] = 2;
                if(existSolution()) {
                    Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
                } else {
                    // Change the player that is playing for the next time
                    isPlayingOne = !isPlayingOne;
                }
            } else {
                Toast.makeText(this, "Select another cell", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean existSolution() {
        boolean exist = false;

        /* CELLS POSITIONS     DEFAULT CELLS VALUE

    *    0  | 1 |  2             0 | 0 | 0
    *   -------------           -----------
    *    3  | 4 |  5    >>>>>>   0 | 0 | 0
    *   -------------           -----------
    *    6  | 7 |  8             0 | 0 | 0
    *    */

        if(selectedCells[0] == selectedCells[1]
        && selectedCells[1] == selectedCells[2]
        && selectedCells[2] != 0) { // 0,1,2
            exist = true;
        } else if(selectedCells[3] == selectedCells[4]
        && selectedCells[4] == selectedCells[5]
        && selectedCells[5] != 0) { // 3,4,5
            exist = true;
        } else if(selectedCells[6] == selectedCells[7]
                && selectedCells[7] == selectedCells[8]
                && selectedCells[8] != 0) { // 6,7,8
            exist = true;
        } else if(selectedCells[0] == selectedCells[3]
                && selectedCells[3] == selectedCells[6]
                && selectedCells[6] != 0) { // 0,3,6
            exist = true;
        } else if(selectedCells[1] == selectedCells[4]
                && selectedCells[4] == selectedCells[7]
                && selectedCells[7] != 0) { // 1,4,7
            exist = true;
        } else if(selectedCells[2] == selectedCells[5]
                && selectedCells[5] == selectedCells[8]
                && selectedCells[8] != 0) { // 2,5,8
            exist = true;
        } else if(selectedCells[0] == selectedCells[4]
                && selectedCells[4] == selectedCells[8]
                && selectedCells[4] != 0) { // 0,4,8
            exist = true;
        } else if(selectedCells[2] == selectedCells[4]
                && selectedCells[4] == selectedCells[6]
                && selectedCells[6] != 0) { // 2,4,6
            exist = true;
        }

        return exist;
    }
}
