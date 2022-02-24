package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.databinding.FragmentHomeBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.activity.AuthenticationActivity
import com.example.android_mvvm_best_pratices.ui.component.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()


    override fun observeViewModel() {

    }

    override fun initViewBinding(layoutInflater: LayoutInflater): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner



        viewModel.movies.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> binding.adapter =
                    MoviesAdapter(it.data!!, R.layout.movie_item)

                is Resource.InternetError,
                is Resource.ServerError -> {
                    Toast.makeText(
                        context,
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    requireActivity().startActivity(
                        Intent(
                            context,
                            AuthenticationActivity::class.java
                        )
                    )
                    requireActivity().finish()

                }


            }
        }
        return binding.root
    }


}