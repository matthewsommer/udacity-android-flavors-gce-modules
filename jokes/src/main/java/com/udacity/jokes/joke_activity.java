package com.udacity.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.udacity.jokes.backend.myApi.MyApi;

public class Joke_Activity extends AppCompatActivity implements AsyncTaskDelegate {

    TextView textViewJoke = null;
    private static MyApi myApiService = null;
    EndpointsAsyncTask.Callback mCallback = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);

        mCallback = new EndpointsAsyncTask.Callback(){
            @Override
            public void onTaskFinished(String joke) {
                textViewJoke = (TextView) findViewById(R.id.textViewJoke);
                if (joke != null) {
                    textViewJoke.setText(joke);
                }
            }
        };

        new EndpointsAsyncTask(mCallback).execute();
    }

    @Override
    public void sendJoke(String joke) {
        textViewJoke = (TextView) findViewById(R.id.textViewJoke);
        if (joke != null) {
            textViewJoke.setText(joke);
        }
    }
}