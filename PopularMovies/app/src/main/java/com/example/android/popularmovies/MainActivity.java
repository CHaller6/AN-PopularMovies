package com.example.android.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the recycler view that displays the movies
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_movies);

        // Call method to get data from the movies data base, and store that data in
        // a list of image items.

        // Create adapter for the RecyclerView, passing a reference to the image data acquired
        // from the movie database
    }
}
