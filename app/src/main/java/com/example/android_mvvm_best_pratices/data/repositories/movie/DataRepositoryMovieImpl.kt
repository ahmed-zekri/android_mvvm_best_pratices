package com.example.android_mvvm_best_pratices.data.repositories.movie

import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.Movie
import com.example.android_mvvm_best_pratices.data.remote.movies.RemoteDataMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepositoryMovieImpl @Inject constructor(
    private val remoteDataSourceMovies: RemoteDataMovies,
    private val coroutineContext: CoroutineContext
) :
    DataRepositoryMovieSource {
    override suspend fun getMovies(): Flow<Resource<List<Movie>>> {
        return flow {

            emit(remoteDataSourceMovies.getAllMovie())

        }.flowOn(coroutineContext)


    }
}