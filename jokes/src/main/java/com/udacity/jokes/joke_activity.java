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

        Intent intent = getIntent();
        String default_joke = intent.getStringExtra("joke");

        //It doesn't make sense for the first activity to have a dependency
        //on the joke generator when the jokes module can be self contained
        //isn't that the point of this architecture? Now if I want to make an
        //app and plug-in a joke generator it would be easy.

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