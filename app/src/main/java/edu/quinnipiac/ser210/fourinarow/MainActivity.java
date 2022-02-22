package edu.quinnipiac.ser210.fourinarow;

//Julia Woeste
//assignment 1 part 2
//2/21/22
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int EMPTY = 0;
    public static final int BLUE = 1;
    public static final int RED = 2;

    public static final int PLAYING = 0;
    public static final int TIE = 1;
    public static final int RED_WON = 2;
    public static final int BLUE_WON = 3;

    public static String KEY_NAME = "name";

    EditText send_name;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_name = (EditText) findViewById(R.id.player1Name);

        //intent for when user inputs their name
        editText = (EditText) findViewById(R.id.player1Name);
    }

    public void onSendMessage(View view){
        //clicked on start game and takes players name
        EditText editText = (EditText) findViewById(R.id.player1Name);
        String messageText = editText.getText().toString();
        Intent intent = new Intent(this, GameBoard.class);
        intent.putExtra(GameBoard.EXTRA_MESSAGE, messageText);
        startActivity(intent);

    }


    public void onClick(View v)
    {
        String str = send_name.getText().toString();

        // Create the Intent object of this class Context() to Second_activity class
        Intent intent = new Intent(getApplicationContext(), GameBoard.class);
        intent.putExtra(KEY_NAME, str);
        // start the Intent
        startActivity(intent);
    }

}