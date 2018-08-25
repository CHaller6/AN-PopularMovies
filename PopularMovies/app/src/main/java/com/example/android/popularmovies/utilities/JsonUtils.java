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
     *  Takes a string containing data returned from the movie database, and extracts that
     *  data into a JSONObject.
     */
    public static JSONObject getJSONObjFromString(String data)
        throws JSONException {

        //TODO: Try-Catch a JSON exception in case the JSONObject chokes on 'data'
        JSONObject object = new JSONObject(data);

        return object;
    }


    /**
     * Takes a JSONObject containing data returned from the movie database, and extracts the
     * content of the "results" fields into a JSONArray.
     */
    public static JSONArray getResultsFromJSONObject(JSONObject object)
        throws JSONException {
        //TODO: Try-Catch a JSON exception in case the JSONObject chokes on 'data'
        JSONArray results = object.getJSONArray("results");

        // Return the JSON Array
        return results;
        
    }

    //TODO: Implement a method to extract a particular requested result within the results JSONArray into it's own JSONObject

}
