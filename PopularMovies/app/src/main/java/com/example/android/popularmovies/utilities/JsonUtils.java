package com.example.android.popularmovies.utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class contains a set of helper methods to process and handle JSON objects
 * and actions from the data received from the movie database.
 */

public final class JsonUtils {
    /**
     *  DATA MEMBERS
     */
    final String BASE_LIST = "results";


    /**
     *  METHODS
     */

    /**
     * Takes a string containing data returned from the movie database, and extracts that
     * data into a JSONArray.
     */
    JSONArray getResultsFromJSONString(String data)
        throws JSONException {
        JSONObject results = new JSONObject(data);
        
    }

    public static String[]

}
