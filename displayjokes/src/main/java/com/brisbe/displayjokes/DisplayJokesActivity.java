package com.brisbe.displayjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        Intent intent = getIntent();
        String jokeString = intent.getStringExtra("joke");

        TextView textViewJoke = (TextView) findViewById(R.id.textViewJoke);
        if (jokeString != null) {
            textViewJoke.setText(jokeString);
        }
    }
}