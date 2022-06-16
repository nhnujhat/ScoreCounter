package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        TextView winner = findViewById(R.id.winner);
        TextView score = findViewById(R.id.score);

        Button call = findViewById(R.id.call);
        Button text = findViewById(R.id.text);
        Button map = findViewById(R.id.map);

        Intent intent = getIntent();
        String winnerstr = intent.getStringExtra("winner_name");
        String scorestr = intent.getStringExtra("winner_score");

        winner.setText(winnerstr);
        score.setText("Won by " + scorestr + " points!");

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"));
                if(android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O) intent.setType("vnd.android-dir/mms-sms");
                intent.putExtra("sms_body", winner.getText().toString() + " " + score.getText().toString());
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/football+near+me"));
                startActivity(intent);
            }
        });
    }
}