package com.example.android.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * An Adapter to help feed movie information to the a RecyclerView that manages and displays a
 * list of movies to the user.
 *
 * (This class was originally written to be used with the RecyclerView in the MainActivity class
 * of the Popular Movies project by Chris Haller).
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    /**
     * Constructor for creating a new MovieAdapter
     */
    public MovieAdapter() {
        // This constructor should accept, as input, the movie data that will be fed to the
        // RecyclerView using this adapter.
    }


    /*
     * This class implements the RecyclerView's ViewHolder class, and acts as a ViewHolder
     * to be used to hold and manage individual movie image data that is sent from the MovieAdapter
     * class to a RecyclerView displaying lists of movie poster images.
     */
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        /**
         * Constructor for creating a new MovieViewHolder
         *
         * @param itemView
         */
        public MovieViewHolder(View itemView) {
            super(itemView);
        }

    }

    /**
     *  This method is called when a MovieViewHolder is created and called.
     *
     *  @param parent
     *  @param viewType
     *
     */
    public MovieViewHolder onCreateViewHolder (ViewGroup parent, int viewType){

        //TODO: Delete this once method is implemented
        return null;
    }

    /**
     *
     *
     * @param holder The view holder that needs to be inflated
     * @param position The position within the data set that corresponds to data that needs to go in this view holder
     *
     *
     */
    public void onBindViewHolder (MovieViewHolder holder, int position) {

    }

    /**
     *
     *  
     *
     */
    public int getItemCount() {

        //TODO: Delete this once the method is implemented
        return 0;
    }
}
