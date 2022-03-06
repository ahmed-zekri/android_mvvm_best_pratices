package com.example.android_mvvm_best_pratices.presentation.home.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.DATA_RETRIEVED_FROM_LOCAL_DATABASE
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.domain.model.movie.Movie
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import com.example.android_mvvm_best_pratices.data.repositories.movie.DataRepositoryMovieImpl
import com.example.android_mvvm_best_pratices.data.room.dao.MovieDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryMovieImpl: DataRepositoryMovieImpl,
    private val movieDao: MovieDao


) :
    ViewModel() {

    val itemDeletedListener = object : ((String?) -> Unit?) {


        override fun invoke(p1: String?) {
            viewModelScope.launch {
                movieDao.deleteMovie(p1)
                fetchMovies()
            }
        }
    }


    val movies = MutableLiveData<Resource<List<Movie>>>()

    fun fetchMovies() {
        movies.postValue(Resource.Loading())
        viewModelScope.launch {

            repositoryMovieImpl.getMovies().collect {
                if (it is Resource.Success)

                    updateDatabase(it.data)


                movies.postValue(
                    if (it.error != NETWORK_ERROR) it else Resource.Success(
                        movieDao.getAllMovies()

                    )
                )

            }
        }

    }

    private fun updateDatabase(data: List<Movie>?) {
        data?.forEach {

            viewModelScope.launch {

                if (movieDao.count(it.title) == 0)
                    movieDao.insertMovie(it)
            }

        }

    }


}