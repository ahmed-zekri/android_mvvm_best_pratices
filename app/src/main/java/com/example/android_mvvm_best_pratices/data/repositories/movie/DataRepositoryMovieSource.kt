package com.example.android_mvvm_best_pratices.data.repositories.movie

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.Movie
import kotlinx.coroutines.flow.Flow


interface DataRepositoryMovieSource {
    suspend fun getMovies(): Flow<Resource<List<Movie>>>
}