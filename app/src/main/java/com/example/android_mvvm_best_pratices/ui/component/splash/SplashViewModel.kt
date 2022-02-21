package com.example.android_mvvm_best_pratices.ui.component.splash

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_best_pratices.TOKEN_KEY
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    BaseViewModel() {

    val hasData = MutableLiveData<Boolean>()


    fun checkData() {

        hasData.postValue(!sharedPreferences.getString(TOKEN_KEY, "")?.equals("")!!)

    }

}