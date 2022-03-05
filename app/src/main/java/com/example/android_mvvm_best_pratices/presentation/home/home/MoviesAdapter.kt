package com.example.android_mvvm_best_pratices.presentation.home.home

import com.example.android_mvvm_best_pratices.domain.model.movie.Movie
import com.example.android_mvvm_best_pratices.databinding.MovieItemBinding
import com.example.android_mvvm_best_pratices.presentation.base.BaseAdapter

class MoviesAdapter constructor(movies: List<Movie>?, override val layoutId: Int) :
    BaseAdapter<MovieItemBinding, Movie>(movies) {

    override fun bind(binder: MovieItemBinding, item: Movie?) {
        binder.apply {

            movie = item
            imageViewDelete.setOnClickListener {
                itemDeleted.invoke(movie?.title)

            }
        }
    }


    var itemDeleted: (title: String?) -> Unit? = {}


}