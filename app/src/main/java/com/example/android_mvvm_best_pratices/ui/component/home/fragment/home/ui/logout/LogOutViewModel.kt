package com.example.android_mvvm_best_pratices.ui.component.home.fragment.home.ui.logout

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogOutViewModel @Inject constructor(private val sharedPreferencesEditor: SharedPreferences.Editor) :
    BaseViewModel() {
    val sharedPrefsCleared = MutableLiveData<Boolean>()
    fun logOut() {

        sharedPreferencesEditor.clear()
        sharedPreferencesEditor.commit()
        sharedPrefsCleared.postValue(true)

    }


}