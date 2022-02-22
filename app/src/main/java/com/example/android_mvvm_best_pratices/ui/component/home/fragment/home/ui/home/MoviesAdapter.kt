package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import com.example.android_mvvm_best_pratices.data.dto.Movie
import com.example.android_mvvm_best_pratices.databinding.MovieItemBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseAdapter

class MoviesAdapter constructor(movies: List<Movie>, override val layoutId: Int) :
    BaseAdapter<MovieItemBinding, Movie>(data = movies) {
    override fun bind(binder: MovieItemBinding, item: Movie) {
        binder.apply {

            movie = item
        }
    }
}