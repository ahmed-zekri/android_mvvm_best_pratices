package com.example.android_mvvm_best_pratices.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginRequest
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginResponse
import com.example.android_mvvm_best_pratices.domain.usecase.authentication.LoginUseCase
import com.example.android_mvvm_best_pratices.domain.usecase.authentication.SaveAtUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveAtUseCase: SaveAtUseCase
) :
    ViewModel() {
    val loginRequest = LoginRequest()
    val loginStatus = MutableLiveData<Resource<LoginResponse>>()


    fun doLogin() {

        viewModelScope.launch {
            loginUseCase(loginRequest).collect {

                if (it is Resource.Success)

                    saveAtUseCase(it)

                loginStatus.postValue(it)
            }


        }


    }


}
