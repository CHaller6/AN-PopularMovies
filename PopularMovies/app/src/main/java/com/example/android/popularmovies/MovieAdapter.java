package com.example.android.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by crey on 9/19/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    /**
     * Constructor for creating a new MovieAdapter
     */
    public MovieAdapter() {

    }

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
     *
     */
    public MovieViewHolder onCreateViewHolder (ViewGroup parent, int viewType){

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

    public int getItemCount() {

    }
}
