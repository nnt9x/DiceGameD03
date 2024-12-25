package com.bkacad.edu.nnt.dicegamed03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView imgDice;
    private TextView tvResult;
    private Button btnReset;
    private int total = 0;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgDice = findViewById(R.id.imgDice);
        tvResult = findViewById(R.id.tvResult);
        btnReset = findViewById(R.id.btnReset);
    }

    public void randomDice(View view) {
        if (count > 0) {
            int randomNum = (int) (Math.random() * 6) + 1; // 0-5 => 1-6
            if (randomNum == 1) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice1));
            } else if (randomNum == 2) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice2));
            } else if (randomNum == 3) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice3));
            } else if (randomNum == 4) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice4));
            } else if (randomNum == 5) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice5));
            } else if (randomNum == 6) {
                imgDice.setImageDrawable(getDrawable(R.drawable.dice6));
            }
            // Tang bien total
            total = total + randomNum;
            // Giam count
            count --;
        }
        if(count == 0){
            // Hien thi total va nut reset hien thi
            tvResult.setText("Total: " + total);
            btnReset.setVisibility(View.VISIBLE);
        }
    }

    public void resetDiceGame(View view) {
        total = 0;
        count = 3;
        tvResult.setText("Total: ?");
        imgDice.setImageDrawable(getDrawable(R.drawable.dice0));
        // An nut rest
        btnReset.setVisibility(View.INVISIBLE);
    }
}