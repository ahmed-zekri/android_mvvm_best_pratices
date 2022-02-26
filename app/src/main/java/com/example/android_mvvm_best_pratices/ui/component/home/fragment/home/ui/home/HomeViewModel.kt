package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.DATA_RETRIEVED_FROM_LOCAL_DATABASE
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.Movie
import com.example.android_mvvm_best_pratices.data.error.NETWORK_ERROR
import com.example.android_mvvm_best_pratices.data.repositories.movie.DataRepositoryMovieImpl
import com.example.android_mvvm_best_pratices.data.room.dao.MovieDao
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryMovieImpl: DataRepositoryMovieImpl,
    private val movieDao: MovieDao


) :
    BaseViewModel() {
    val onItemDeletedListener = object : MoviesAdapter.OnItemDeletedListener {
        override fun onDeleted(title: String?) {
            viewModelScope.launch {
                movieDao.deleteMovie(title)
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
                        movieDao.getAllMovies(),
                        DATA_RETRIEVED_FROM_LOCAL_DATABASE
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