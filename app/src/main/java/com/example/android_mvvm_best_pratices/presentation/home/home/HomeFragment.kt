package com.example.android_mvvm_best_pratices.presentation.home.home

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.databinding.FragmentHomeBinding
import com.example.android_mvvm_best_pratices.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private var adapter: MoviesAdapter = MoviesAdapter(null, R.layout.movie_item)

    override fun observeViewModel() {
        viewModel.fetchMovies()

        viewModel.movies.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    adapter.updateData(it.data!!)

                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

                }

                else -> {}
            }
        }
    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        binding.adapter = adapter
        adapter.itemDeleted = viewModel.itemDeletedListener



        return binding.root
    }


}