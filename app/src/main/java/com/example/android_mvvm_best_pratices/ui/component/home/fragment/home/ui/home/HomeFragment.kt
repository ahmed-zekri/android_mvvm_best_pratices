package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_mvvm_best_pratices.R
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.databinding.FragmentHomeBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.activity.AuthenticationActivity
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



        viewModel.movies.observe(viewLifecycleOwner) {
            if (it is Resource.Success)
                binding.adapter = MoviesAdapter(it.data!!, R.layout.movie_item)
            if (it is Resource.ServerError) {
                Toast.makeText(
                    context,
                    if (it.message.equals("")) it.message else it.error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                requireActivity().startActivity(Intent(context, AuthenticationActivity::class.java))
                requireActivity().finish()

            }
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}