package com.example.android_mvvm_best_pratices.ui.component.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.android_mvvm_best_pratices.SPLASH_DELAY
import com.example.android_mvvm_best_pratices.databinding.ActivitySplashBinding
import com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login.LoginFragment

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToLogin()
    }

    private fun navigateToLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)

        }, SPLASH_DELAY.toLong())

    }


}