package com.example.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {

    private ImageView moviePoster;
    private TextView movieTitle,userRating,releaseDate,movieSynopsis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        moviePoster = findViewById(R.id.movie_thumbnail);
        movieTitle = findViewById(R.id.movie);
        userRating = findViewById(R.id.rating);
        releaseDate = findViewById(R.id.date);
        movieSynopsis = findViewById(R.id.synopsis);

        Bundle bundle = getIntent().getExtras();
        Movie movie = (Movie) bundle.getSerializable("movieData");
        getMovieData(movie);

    }
    private void getMovieData(Movie movie) {
        Glide.with(this)
                .load(imagePath(movie.getPosterPath()))
                .into(moviePoster);

        movieTitle.setText(movie.getTitle());
        userRating.setText(String.format("%s/10", movie.getVoteAverage()));
        releaseDate.setText(movie.getReleaseDate());
        movieSynopsis.setText(movie.getOverview());
    }

    private static String imagePath(String posterPath) {
        return "https://image.tmdb.org/t/p/" + "w500" + posterPath;
    }
}
