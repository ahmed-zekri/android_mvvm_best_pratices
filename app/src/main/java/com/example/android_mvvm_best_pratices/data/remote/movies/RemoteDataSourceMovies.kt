package com.example.android_mvvm_best_pratices.data.remote.movies

interface RemoteDataSourceMovies {
    suspend fun getAllMovie(): Any?

}