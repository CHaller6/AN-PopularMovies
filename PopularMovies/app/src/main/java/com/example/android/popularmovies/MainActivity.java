package com.example.android.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    /*
      ===============================================================================
      ******************
      ** Data Members **
      ******************
      ===============================================================================
     */
    // Pointer to the RecyclerView that displays the films on the main activity
    RecyclerView mRecyclerView;

    // The number of columns in the display (aka the number of movies shown from left to right)
    private final int SPANCOUNT = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the recycler view that displays the movies
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_movies);

        // Create a grid layout manager for the recyclerview to use to display the movie data
        GridLayoutManager layoutManager = new GridLayoutManager(this, SPANCOUNT,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        // TODO: Call method to get data from the movies data base, and store that data in
        // a list of image items. This should be done using aSyncTask so as not to take up
        // CPU cycles from the Main/UI thread.

        // Create adapter for the RecyclerView, passing a reference to the image data acquired
        // from the movie database
        MovieAdapter mAdapter = new MovieAdapter();
    }
}
