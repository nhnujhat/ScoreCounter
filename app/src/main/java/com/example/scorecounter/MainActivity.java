package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int asc = 0, bsc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ascore = findViewById(R.id.ascore);
        TextView bscore = findViewById(R.id.bscore);
        Button ascorebtn = findViewById(R.id.ascorebtn);
        Button bscorebtn = findViewById(R.id.bscorebtn);

        ascorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asc++;
                if(asc==5) {
                    int temp = asc-bsc;
                    Intent intent = new Intent(getApplicationContext(), WinnerActivity.class);
                    intent.putExtra("winner_name", "Team A");
                    intent.putExtra("winner_score", String.valueOf(temp));
                    startActivity(intent);
                }
                ascore.setText(String.valueOf(asc));
            }
        });

        bscorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bsc++;
                if(bsc==5) {
                    int temp = bsc-asc;
                    Intent intent = new Intent(getApplicationContext(), WinnerActivity.class);
                    intent.putExtra("winner_name", "Team B");
                    intent.putExtra("winner_score", String.valueOf(temp));
                    startActivity(intent);
                }
                bscore.setText(String.valueOf(bsc));
            }
        });
    }
}