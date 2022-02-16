package com.example.android_mvvm_best_pratices.data.remote

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET

interface APIMoviesService {

    @GET("test/movies")
    suspend fun getMovies(): Response<*>

}