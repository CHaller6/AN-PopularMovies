package com.example.android.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.popularmovies.utilities.JsonUtils;
import com.example.android.popularmovies.utilities.NetworkUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    /*
      ===============================================================================
      **********************
      **** Data Members ****
      **********************
      ===============================================================================
     */

    // An enum structure to represent the sorting options for the movie database
    private enum SortMethod {
        POPULAR, RATED
    }

    // Represents the sorting option to be used when querying the database. The default value
    // is POPULAR
    SortMethod method = SortMethod.POPULAR;

    // Pointer to the RecyclerView that displays the films on the main activity
    RecyclerView mRecyclerView;

    // The number of columns in the display (aka the number of movies shown from left to right)
    private final int SPANCOUNT = 2;



    /*
      ===============================================================================
      **********************
      ****** Methods *******
      **********************
      ===============================================================================
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the recycler view that displays the movies
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_movies);

        //TODO: Comment out the GridLayoutManager and try a LinearLayoutManager to see if the
        // RecyclerView appears on the screen.
        // Edit: Tested this, and just like the GridLayoutManager, the screen showed up blanks. It may need some
        //       data supplied first in order for the RecyclerView to render anything on the UI.
        LinearLayoutManager tempLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        mRecyclerView.setLayoutManager(tempLayoutManager);

        /*
        // Create a grid layout manager for the recyclerview to use to display the movie data
        GridLayoutManager layoutManager = new GridLayoutManager(this, SPANCOUNT,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        */

        // Build the URL to be used to retrieve the movie data from the movie database
        URL query_URL = null;
        switch(method) {
            case POPULAR:
                query_URL = NetworkUtils.makePopularMovieSearchQuery(getString(R.string.movie_api_key));
            case RATED:
                query_URL = NetworkUtils.makeRatedMovieSearchQuery(getString(R.string.movie_api_key));
        }

        // TODO: Get data from the movies database, and store that data in
        // a JSON object. This should be done using aSyncTask so as not to take up
        // CPU cycles from the Main/UI thread.
        new FetchMovieData().execute(query_URL);


        // Create adapter for the RecyclerView, passing a reference to the image data acquired
        // from the movie database
        MovieAdapter mAdapter = new MovieAdapter();
    }



    /**
     * This thread uses AsyncTask to access the most recent movie data from the online movie
     * database, and then returns it to the main thread.
     *
     */
    public class FetchMovieData extends AsyncTask<URL, Void, JSONObject>{
        /**
         *
         * @param params This will contain the URL to retrieve all of the movie data
         * @return The JSON string (unparsed and in String form) returned from the movie database
         */
        @Override
        protected JSONObject doInBackground (URL... params) {
            // Check to make sure that the input parameter isn't empty
            if (params.length == 0) {
                return null;
            }
            URL searchURL = params[0];
            String movie_response_string;

            // TODO: Call the network utility class, passing in the URL, and accept the returned data
            try {
                movie_response_string = NetworkUtils.getResponseFromHttpUrl(searchURL);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            /* TODO: Take the contents returned from the movie database and put them in
               a JSON Object */
            try {
                JSONObject movie_response_json_object = JsonUtils.
                        getJSONObjFromString(movie_response_string);
            } catch (JSONException e) {
                /* TODO: Print the JSON exception to output or popup a toast with the exception
                   and return */

            }



            // TODO: Remove this
            return null;
        }

    }

}
