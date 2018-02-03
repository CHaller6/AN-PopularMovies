package com.example.android.popularmovies;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    /*
      ===============================================================================
      **********************
      **** Data Members ****
      **********************
      ===============================================================================
     */

    // Parameter for the API Key
    final static String DB_API_KEY = "api_key";

    // API Key for the movie database    TODO: Note: This must be removed before any commits!
    private static final String apiKey = "";

    // Parameter for the sorting method
    final static String DB_SORT_BY = "sort_by";

    // Value for the sorting method
    private static String sortMethod = "popularity.desc";

    // The domain portion of the URL request
    static final String DB_BASE_STANDARD = "https://api.themoviedb.org/3/discover/movie";

    // The domain portion of the URL request for images from the movie database
    static final String DB_BASE_IMAGE= "";

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

    /*
     * This thread uses AsyncTask to access the most recent movie data from the online movie
     * database, and then returns it to the main thread.
     *
     */
    public class FetchMovieData extends AsyncTask<URL, Void, String>{
        @Override
        protected String doInBackground (URL... params) {
            URL searchURL = params[0];
            // TODO: Instantiate the object that will take the results from the database


            // TODO: Remove this
            return null;
        }

    }


    /**
     *
     * This method builds the URL to send to the popular movies database to retrieve the most
     * popular movies. It returns this as a URL object.
     *
     * TODO: https://api.themoviedb.org/3/discover/movie?api_key=KEY_HERE&sort_by=popularity.desc
     *
     */
    private static URL makePopularMovieSearchQuery() {
        Uri builtUri = Uri.parse(DB_BASE_STANDARD).buildUpon()
                .appendQueryParameter(DB_API_KEY, apiKey)
                .appendQueryParameter(DB_SORT_BY, sortMethod)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //Log.v(TAG, "Built URI " + url);

        return url;
    }

}
