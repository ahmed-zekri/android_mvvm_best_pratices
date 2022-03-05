package com.example.android_mvvm_best_pratices.presentation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mvvm_best_pratices.SPLASH_DELAY
import com.example.android_mvvm_best_pratices.databinding.ActivitySplashBinding
import com.example.android_mvvm_best_pratices.presentation.AuthenticationActivity
import com.example.android_mvvm_best_pratices.presentation.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.checkData()
        viewModel.hasData.observe(this) {

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(
                    this,
                    if (it) HomeActivity::class.java else AuthenticationActivity::class.java
                )
                startActivity(intent)

            }, SPLASH_DELAY.toLong())


        }

    }




}