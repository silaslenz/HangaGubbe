package com.rorlez.hangagubbe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    public String current_word = "apkalas";
    public TextView txv_word;
    public TextView txv_lives;
    public int livesLeft = 5;
    public GridLayout btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        btnGrid = (GridLayout) findViewById(R.id.buttonGrid);
        txv_word = (TextView) findViewById(R.id.txv_word);
        txv_lives = (TextView) findViewById(R.id.textView);
        txv_word.setText(lineCounter(current_word));

    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        final Button buttona = (Button) findViewById(R.id.button_a);
        final Button buttonb = (Button) findViewById(R.id.button_b);
        final Button buttonc = (Button) findViewById(R.id.button_c);
        final Button buttond = (Button) findViewById(R.id.button_d);
        final Button buttone = (Button) findViewById(R.id.button_e);
        final Button buttonf = (Button) findViewById(R.id.button_f);
        final Button buttong = (Button) findViewById(R.id.button_g);
        final Button buttonh = (Button) findViewById(R.id.button_h);
        final Button buttoni = (Button) findViewById(R.id.button_i);
        final Button buttonj = (Button) findViewById(R.id.button_j);
        final Button buttonk = (Button) findViewById(R.id.button_k);
        final Button buttonl = (Button) findViewById(R.id.button_l);
        final Button buttonm = (Button) findViewById(R.id.button_m);
        final Button buttonn = (Button) findViewById(R.id.button_n);
        final Button buttono = (Button) findViewById(R.id.button_o);
        final Button buttonp = (Button) findViewById(R.id.button_p);
        final Button buttonq = (Button) findViewById(R.id.button_q);
        final Button buttonr = (Button) findViewById(R.id.button_r);
        final Button buttons = (Button) findViewById(R.id.button_s);
        final Button buttont = (Button) findViewById(R.id.button_t);
        final Button buttonu = (Button) findViewById(R.id.button_u);
        final Button buttonv = (Button) findViewById(R.id.button_v);
        final Button buttonw = (Button) findViewById(R.id.button_w);
        final Button buttonx = (Button) findViewById(R.id.button_x);
        final Button buttony = (Button) findViewById(R.id.button_y);
        final Button buttonz = (Button) findViewById(R.id.button_z);
        final Button buttonoa = (Button) findViewById(R.id.button_oa);
        final Button buttonae = (Button) findViewById(R.id.button_ae);
        final Button buttonoe = (Button) findViewById(R.id.button_oe);
        final TextView txv_word = (TextView) findViewById(R.id.txv_word);

        buttona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int location = -1;
                boolean endofword = false;
                while (endofword == false) {
                    if (current_word.contains("p")) {
                        location = current_word.indexOf("a", location+1);
                        System.out.println(location);
                        txv_word.setText(Integer.toString(location));
                    }
                    if (location<0){
                        endofword=true;
                    }
                    buttona.setEnabled(false);
                }
            }
        });
        return true;
    }*/
    public void disableSomething(View view) {
        Button b = (Button) view;
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

                if (livesLeft ==0 ) {
                    txv_lives.setText("Game Over");
                    btnGrid.setVisibility(View.GONE);
                }
            }
            if (location < 0) {
                endofword = true;
            }
            txv_word.setText(new String(wordArray));
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
