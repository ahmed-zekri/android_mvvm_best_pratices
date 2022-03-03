package com.example.android_mvvm_best_pratices.data.remote.movies

import com.example.android_mvvm_best_pratices.domain.model.movie.Movie
import retrofit2.Response
import retrofit2.http.GET

interface APIMoviesService {

    @GET("test/movies")
    suspend fun getMovies(): Response<List<Movie>>

}