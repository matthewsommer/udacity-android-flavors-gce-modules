package com.udacity.displayjokes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.TextView;

import java.io.IOException;

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        Intent intent = getIntent();
        String jokeString = intent.getStringExtra("joke");

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));

        TextView textViewJoke = (TextView) findViewById(R.id.textViewJoke);
        if (jokeString != null) {
            textViewJoke.setText(jokeString);
        }
    }

    class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
        private Context context;

        @Override
        protected String doInBackground(Pair<Context, String>... params) {

            context = params[0].first;
            String name = params[0].second;

            return "test";
//            try {
//                return "Test";
//            } catch (IOException e) {
//                return e.getMessage();
//            }
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
}