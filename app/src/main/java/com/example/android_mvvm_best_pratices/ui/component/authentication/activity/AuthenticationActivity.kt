package com.example.android_mvvm_best_pratices.ui.component.authentication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_mvvm_best_pratices.databinding.ActivityAuthenticationBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.adapter.PageAdapter

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = PageAdapter(this, listOf("Login", "Register"))

    }
}