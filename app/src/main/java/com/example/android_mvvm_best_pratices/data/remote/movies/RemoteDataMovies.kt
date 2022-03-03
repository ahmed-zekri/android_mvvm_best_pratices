package com.example.android_mvvm_best_pratices.data.remote.movies

import com.example.android_mvvm_best_pratices.DATA_FETCHED_FROM_SERVER
import com.example.android_mvvm_best_pratices.ERROR_DELIMITER
import com.example.android_mvvm_best_pratices.NO_INTERNET_CONNECTION_ERROR
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.domain.model.movie.Movie
import com.example.android_mvvm_best_pratices.ui.component.base.BaseRemoteData
import javax.inject.Inject

class RemoteDataMovies @Inject constructor(serviceGenerator: ServiceGenerator) :
    BaseRemoteData(serviceGenerator), RemoteDataSourceMovies {
    override suspend fun getAllMovie(): Resource<List<Movie>> {

        return when (val response = processCall { movieService.getMovies() }) {

            is List<*> -> Resource.Success(
                data = response as List<Movie>,
                message = DATA_FETCHED_FROM_SERVER
            )
            is Int -> Resource.InternetError(
                message = NO_INTERNET_CONNECTION_ERROR,
                error = response
            )
            else -> Resource.ServerError(
                message = (response as String).split(ERROR_DELIMITER)[1],
                error = response.split(ERROR_DELIMITER)[0].toInt()
            )


        }

    }

}