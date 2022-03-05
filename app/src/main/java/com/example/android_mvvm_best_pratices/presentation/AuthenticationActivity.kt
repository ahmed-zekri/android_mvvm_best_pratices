package com.example.android_mvvm_best_pratices.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mvvm_best_pratices.databinding.ActivityAuthenticationBinding
import com.example.android_mvvm_best_pratices.presentation.adapter.PageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : AppCompatActivity() {

    lateinit var binding: ActivityAuthenticationBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PageAdapter(this)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = if (position == 0) "Login" else "Register"
        }.attach()


    }
}