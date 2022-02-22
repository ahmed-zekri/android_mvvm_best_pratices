package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.databinding.FragmentHomeBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModels()


    private val binding get() = _binding!!
    override fun observeViewModel() {

    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {

        _binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel
        viewModel.movies.observe(viewLifecycleOwner) {
            binding.adapter = MoviesAdapter(it, R.layout.movie_item)


        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}