package edu.quinnipiac.ser210.fourinarow;

//Julia Woeste
//assignment 1 part 2
//2/21/22
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    public static FourInARow FIRboard;

    private static final int ROWS = 6, COLS = 6; // number of rows and columns
    private int[][] board = new int[ROWS][COLS];

    //array list of buttons
    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.cell1,
            R.id.cell2,
            R.id.cell3,
            R.id.cell4,
            R.id.cell5,
            R.id.cell6,
            R.id.cell7,
            R.id.cell8,
            R.id.cell9,
            R.id.cell10,
            R.id.cell11,
            R.id.cell12,
            R.id.cell13,
            R.id.cell14,
            R.id.cell15,
            R.id.cell16,
            R.id.cell17,
            R.id.cell18,
            R.id.cell19,
            R.id.cell20,
            R.id.cell21,
            R.id.cell22,
            R.id.cell23,
            R.id.cell24,
            R.id.cell25,
            R.id.cell26,
            R.id.cell27,
            R.id.cell28,
            R.id.cell29,
            R.id.cell30,
            R.id.cell31,
            R.id.cell32,
            R.id.cell33,
            R.id.cell34,
            R.id.cell35,
            R.id.cell36,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        //pass the name to second screen
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.playerName);
        messageView.setText(messageText);


        //for buttons in array, for computer move
        buttons = new ArrayList<Button>();
        for (int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            buttons.add(button);
        }

        //creating instance of four in a row
        FIRboard = new FourInARow();
    }

    //button to restart game
    public void restartGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    //click method for the buttons on the board
    public void onClick(View view) {

        //for loop for array of buttons
        int cell = 0;
        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getId() == view.getId()) {
                cell = i;
                break;
            }
        }
        //get the player move and set color to blue
        Button button = buttons.get(cell);
        button.setBackgroundColor(Color.BLUE);
        FIRboard.setMove(FourInARow.BLUE, cell);

        //gets the computer move and sets the button to red
        FIRboard.setMove(FourInARow.RED, FIRboard.getComputerMove());
        button = buttons.get(FIRboard.getComputerMove());
        button.setBackgroundColor(Color.RED);

        //checking for winner, loser, or tie
        FIRboard.checkForWinner();
        if(FIRboard.checkForWinner() == 1){
            TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
            gameStatus.setText("Its a Tie!");
        }
        if(FIRboard.checkForWinner() == 2){
            TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
            gameStatus.setText("You Lost!");
        }
        if(FIRboard.checkForWinner() == 3){
            TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
            gameStatus.setText("You Won!");
        }

    }

}
