package com.example.popularmovies.network;

import com.example.popularmovies.MovieUpdate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    //Top Rated Movie
    @GET("movie/top_rated")
    Call<MovieUpdate> getTopRatedMovies(@Query("page") int page, @Query("api_key") String apiKey);


    //Most popular movies
    @GET("movie/popular")
    Call<MovieUpdate> getPopularMovies(@Query("page") int page, @Query("api_key") String apiKey);

}

