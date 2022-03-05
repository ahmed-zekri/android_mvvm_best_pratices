package com.example.android_mvvm_best_pratices.presentation.splash

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_mvvm_best_pratices.TOKEN_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ViewModel() {

    val hasData = MutableLiveData<Boolean>()


    fun checkData() {

        hasData.postValue(!sharedPreferences.getString(TOKEN_KEY, "")?.equals("")!!)

    }

}