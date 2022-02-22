package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.Resource

import com.example.android_mvvm_best_pratices.data.dto.Movie
import com.example.android_mvvm_best_pratices.data.repositories.movie.DataRepositoryMovieImpl
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryMovieImpl: DataRepositoryMovieImpl,

    ) :
    BaseViewModel() {


    val movies = MutableLiveData<Resource<List<Movie>>>()

    init {
        movies.postValue(Resource.Loading())
        viewModelScope.launch {
            repositoryMovieImpl.getMovies().collect {


                movies.postValue(it)
            }
        }


    }


}