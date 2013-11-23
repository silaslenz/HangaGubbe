package com.rorlez.hangagubbe;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    public String current_word = "apkalas";
    public TextView txv_word;
    public TextView txv_lives;
    public TextView txv_game_over;
    public int livesLeft = 5;
    public GridLayout btnGrid;
    public static final String PREFS_NAME = "MyPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        btnGrid = (GridLayout) findViewById(R.id.buttonGrid);
        txv_word = (TextView) findViewById(R.id.txv_word);
        txv_lives = (TextView) findViewById(R.id.txv_lives);
        txv_word.setText(lineCounter(current_word));

    }

    public void startGame(View view) {
        livesLeft=5;
        setContentView(R.layout.game_activity);
        btnGrid = (GridLayout) findViewById(R.id.buttonGrid);
        txv_word = (TextView) findViewById(R.id.txv_word);
        txv_lives = (TextView) findViewById(R.id.txv_lives);
        txv_word.setText(lineCounter(current_word));
        txv_word.setText(lineCounter(current_word));
    }
    public void disableSomething(View view) {
        Button b = (Button) view;
        final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        b.setEnabled(false);
        String buttonText = b.getText().toString().toLowerCase();
        int location = -1;
        boolean endofword = false;
        String word=txv_word.getText().toString();
        char[] wordArray = word.toCharArray();
        while (endofword == false) {
            if (current_word.contains(buttonText)) {
                location = current_word.indexOf(buttonText, location + 1);
                System.out.println(location);
                //System.out.println(txv_word.getText().charAt(location*2));
                //txv_word.getText().toString().

                if (location >= 0) {
                    //System.out.println(changeCharInPosition((location*2), 'a',word ));
                    wordArray[location*2] = buttonText.toCharArray()[0];
                }

            }

            else {
                livesLeft -= 1;
                txv_lives.setText(Integer.toString(livesLeft));

                if (livesLeft == 0 ) {
                    txv_lives.setText("Game Over");
                    int losses = settings.getInt("losses", 0);
                    editor.putInt("losses", (losses+=1));

                    setContentView(R.layout.game_over);

                    txv_game_over = (TextView)  findViewById(R.id.txv_game_over);
                    txv_game_over.setText("Du hittade inte ordet");
                }
            }
            if (location < 0) {
                endofword = true;
            }
            txv_word.setText(new String(wordArray));

            editor.commit();
        }

        if (word.contains("_ ")) {

        }
        else {
            int wins = settings.getInt("wins", 0);
            editor.putInt("wins", (wins+=1));

            setContentView(R.layout.game_over);

            txv_game_over = (TextView)  findViewById(R.id.txv_game_over);
            txv_game_over.setText("Du hittade ordet");
        }
    }

   // public String changeCharInPosition(int position, char ch, String str) {


    //    return new String(charArray);
    //}

    public String lineCounter(String word) {
        String lines = "";
        for (int i = 1; i <= word.length(); i++) {
            lines = lines + "_ ";
            //System.out.println(i);
        }
        return lines;
    }

}
