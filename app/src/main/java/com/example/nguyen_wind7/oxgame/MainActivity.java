package com.example.nguyen_wind7.oxgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1, tv2, tv3;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, btReset;
    boolean bl = true;
    int i = 1, j = 1, k = 1;
    int roundCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setID();


        btReset = (Button) findViewById(R.id.btReset);
        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mReset();
            }
        });


    }

    public void setID() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (bl) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        roundCount++;
        if (checkWin()){
            if (bl){
                xWin();
            } else {
                oWin();
            }
        } else if (roundCount==9){
            draw();
        } else {
            bl =! bl;
        }


    }

    public boolean checkWin() {
        String a1, a2, a3, b1, b2, b3, c1, c2, c3;
        a1 = bt1.getText().toString();
        a2 = bt2.getText().toString();
        a3 = bt3.getText().toString();
        b1 = bt4.getText().toString();
        b2 = bt5.getText().toString();
        b3 = bt6.getText().toString();
        c1 = bt7.getText().toString();
        c2 = bt8.getText().toString();
        c3 = bt9.getText().toString();

        if (a1.equals(a2) && a1.equals(a3) && a1.equals("X")) {
            return true;
        } else if (a1.equals(a2) && a1.equals(a3) && a1.equals("O")) {
            return true;
        } else if (b1.equals(b2) && b1.equals(b3) && b1.equals("X")) {
            return true;
        } else if (b1.equals(b2) && b1.equals(b3) && b1.equals("O")) {
            return true;
        } else if (c1.equals(c2) && c1.equals(c3) && c1.equals("X")) {
            return true;
        } else if (c1.equals(c2) && c1.equals(c3) && c1.equals("O")) {
            return true;
        } else if (a1.equals(b1) && a1.equals(c1) && a1.equals("X")) {
            return true;
        } else if (a1.equals(b1) && a1.equals(c1) && a1.equals("O")) {
            return true;
        } else if (a2.equals(b2) && a2.equals(c2) && a2.equals("X")) {
            return true;
        } else if (a2.equals(b2) && a2.equals(c2) && a2.equals("O")) {
            return true;
        } else if (a3.equals(b3) && a3.equals(c3) && a3.equals("X")) {
            return true;
        } else if (a3.equals(b3) && a3.equals(c3) && a3.equals("O")) {
            return true;
        } else if (a1.equals(b2) && a1.equals(c3) && a1.equals("X")) {
            return true;
        } else if (a1.equals(b2) && a1.equals(c3) && a1.equals("O")) {
            return true;
        } else if (a3.equals(b2) && a3.equals(c1) && a3.equals("X")) {
            return true;
        } else if (a3.equals(b2) && a3.equals(c1) && a3.equals("O")) {
            return true;
        }
        return false;
    }

    public void mReset() {
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
        bl = true;
        roundCount=0;
    }

    public void xWin() {
        tv1.setText(i + "");
        i++;
        Toast.makeText(this, "X Win", Toast.LENGTH_LONG).show();
        mReset();
    }

    public void oWin() {
        tv2.setText(j + "");
        j++;
        Toast.makeText(this, "O Win", Toast.LENGTH_LONG).show();
        mReset();

    }

    public void draw() {
        Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show();
        tv3.setText(k + "");
        k++;
        mReset();
    }


}
