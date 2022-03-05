package com.example.android_mvvm_best_pratices.presentation.home.logout

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogOutViewModel @Inject constructor(private val sharedPreferencesEditor: SharedPreferences.Editor) :
    ViewModel() {
    val sharedPrefsCleared = MutableLiveData<Boolean>()
    fun logOut() {

        sharedPreferencesEditor.clear()
        sharedPreferencesEditor.commit()
        sharedPrefsCleared.postValue(true)

    }


}