package com.example.android.popularmovies.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtils {

/*
    ========              ========
    ======== DATA MEMBERS ========
    ========              ========
*/
    // TODO: Remove these if unused
    // Value for two methods of sorting, to be selected by the user. Default is popularity
    final static String SORT_POP = "popularity.desc";
    final static String SORT_RATED = "top_rated";

    // Parameter for the API Key
    final static String DB_API_KEY = "api_key";

    // API Key for the movie database
    // TODO: Note: This must be removed before any commits!
    private static final String apiKey = "";

    // Parameter for the sorting method
    final static String DB_SORT_BY = "sort_by";

    // TODO: Remove this if unused
    // The domain portion of the URL request
    static final String DB_BASE_STANDARD = "https://api.themoviedb.org/3/discover/movie";

    // The domain portion of the URL request for images from the movie database
    static final String DB_BASE_IMAGE= "http://image.tmdb.org/t/p/w185";



/*
    ========         ========
    ======== METHODS ========
    ========         ========
*/

    /**
     *
     * This method builds the URL to send to the popular movies database to retrieve the most
     * popular movies. It returns this as a URL object.
     *
     * TODO: https://api.themoviedb.org/3/discover/movie?api_key=KEY_HERE&sort_by=popularity.desc
     *
     */
    public static URL makePopularMovieSearchQuery() {
        Uri builtUri = Uri.parse(DB_BASE_STANDARD).buildUpon()
                .appendQueryParameter(DB_API_KEY, apiKey)
                .appendQueryParameter(DB_SORT_BY, SORT_POP)
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


    /**
     *
     * This method builds the URL to send to the popular movies database to retrieve the most
     * popular movies. It returns this as a URL object.
     *
     * TODO: https://api.themoviedb.org/3/discover/movie?api_key=KEY_HERE&sort_by=top_rated
     *
     */
    public static URL makeRatedMovieSearchQuery() {
        Uri builtUri = Uri.parse(DB_BASE_STANDARD).buildUpon()
                .appendQueryParameter(DB_API_KEY, apiKey)
                .appendQueryParameter(DB_SORT_BY, SORT_RATED)
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


    /**
     * This method returns the entire result from the HTTP response.
     *
     * Note: This helper method was copied from the NetworkUtils.java class in the utilities package
     * of Project Sunshine in the Android Nanodegree Program from Udacity. It was not written
     * by the author of this class.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }



}
