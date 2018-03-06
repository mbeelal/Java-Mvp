package com.awok.assignment.ui.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.awok.assignment.R;
import com.awok.assignment.data.model.MoviePoster;
import com.awok.assignment.ui.base.view.BaseActivity;
import com.awok.assignment.ui.detail.interactor.MovieDetailInteractor;
import com.awok.assignment.ui.detail.presenter.MovieDetailPresenter;
import com.awok.assignment.util.AppConstants;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

public class MovieDetailActivity extends BaseActivity implements DetailView{

    @Inject
    MovieDetailPresenter<DetailView, MovieDetailInteractor> presenter;

    public static void launchActivity(Context context, String id) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("movieId", id);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter.onAttach(this);

        if (getIntent().hasExtra("movieId")) {
            presenter.getMovieDetails(getIntent().getStringExtra("movieId"));
        }
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMovieDetail(MoviePoster moviePoster) {
        String imageUrl = AppConstants.IMAGE_BASE_URL + moviePoster.getPosterPath();
        ((SimpleDraweeView)findViewById(R.id.poster_image)).setImageURI(imageUrl);

        ((TextView)findViewById(R.id.overview)).setText(moviePoster.getOverview());

        ((CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar)).setTitle(moviePoster.getTitle());

        ((TextView)findViewById(R.id.release_date)).setText(moviePoster.getReleaseDate());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < moviePoster.getGenres().size(); i++) {
            builder.append(moviePoster.getGenres().get(i).getName());
            if ((i + 1) !=  moviePoster.getGenres().size()) {
                builder.append(", ");
            }
        }
        ((TextView)findViewById(R.id.genre)).setText(builder.toString());
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
