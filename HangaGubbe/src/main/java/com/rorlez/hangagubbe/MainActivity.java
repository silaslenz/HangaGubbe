package com.rorlez.hangagubbe;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lineCounter("word");
        setContentView(R.layout.game_activity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        final String current_word = "apkalas";
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
    }
    public void lineCounter (String word){
        TextView txv_word = (TextView) findViewById(R.id.txv_word);
        txv_word.setText("ssss");
    }

}
