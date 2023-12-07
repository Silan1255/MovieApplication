package com.example.movieapplication.data.api

import com.example.movieapplication.data.model.Movie
import com.example.movieapplication.data.model.MovieDetail
import com.example.movieapplication.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApplicationService {
    @GET(Constants.BASE_URL + "movie/now_playing")
    suspend fun getMovieForSlider(
    ): Movie

    @GET(Constants.BASE_URL + "movie/upcoming")
    suspend fun getMovieList(
        @Query("page") page: Int
    ): Movie

    @GET(Constants.BASE_URL + "movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int?
    ): MovieDetail
}