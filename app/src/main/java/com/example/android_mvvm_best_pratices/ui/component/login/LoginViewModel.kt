package com.example.android_mvvm_best_pratices.ui.component.login

import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val dataRepository: DataRepository) :
    BaseViewModel() {
    var userName: String = "cdscsxc"
    var password: String = "sd"
    fun doRegister(registerRequest: RegisterRequest) {

        viewModelScope.launch { dataRepository.doRegister(registerRequest) }


    }
}