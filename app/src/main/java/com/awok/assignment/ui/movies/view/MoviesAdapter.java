package com.awok.assignment.ui.movies.view;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.awok.assignment.R;
import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.detail.view.MovieDetailActivity;
import com.awok.assignment.util.AppConstants;

import java.util.List;

import javax.inject.Inject;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<MoviePoster> moviePosters;

    public void setMoviePosters(List<MoviePoster> moviePosters) {
        this.moviePosters = moviePosters;
    }

    @Inject
    public MoviesAdapter(List<MoviePoster> moviePosters) {
        this.moviePosters = moviePosters;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, int position) {
        holder.bindData(moviePosters.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetailActivity.launchActivity(holder.itemView.getContext(), moviePosters.get(holder.getAdapterPosition()).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviePosters.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImage;
        MovieViewHolder(View itemView) {
            super(itemView);
            posterImage = itemView.findViewById(R.id.poster_image);
        }

        void bindData(MoviePoster moviePoster) {
            String imageUrl = AppConstants.IMAGE_BASE_URL + moviePoster.getPosterPath();

            posterImage.setImageURI(Uri.parse(imageUrl));
        }
    }
}






