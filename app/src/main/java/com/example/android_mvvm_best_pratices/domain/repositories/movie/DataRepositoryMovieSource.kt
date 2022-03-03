package com.example.android_mvvm_best_pratices.domain.repositories.movie

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow


interface DataRepositoryMovieSource {
    suspend fun getMovies(): Flow<Resource<List<Movie>>>
}