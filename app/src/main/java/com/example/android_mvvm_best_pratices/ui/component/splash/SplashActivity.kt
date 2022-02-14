package com.example.android_mvvm_best_pratices.ui.component.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.android_mvvm_best_pratices.SPLASH_DELAY
import com.example.android_mvvm_best_pratices.databinding.ActivitySplashBinding
import com.example.android_mvvm_best_pratices.ui.component.base.BaseActivity
import com.example.android_mvvm_best_pratices.ui.component.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun observeViewModel() {

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun initViewBinding() {
       // TODO("No implementation required")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToLogin()
    }

    private fun navigateToLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }, SPLASH_DELAY.toLong())

    }


}