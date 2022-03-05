package com.example.android_mvvm_best_pratices.presentation.register

import android.widget.CompoundButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.domain.model.user.User
import com.example.android_mvvm_best_pratices.domain.usecase.authentication.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :
    ViewModel() {


    val registerRequest = RegisterRequest()
    val registerStatus = MutableLiveData<Resource<User>>()


    val checkBoxCheckedStateListener =
        CompoundButton.OnCheckedChangeListener { p0, p1 ->

            if (p1)

                registerRequest.roles += p0.text.toString()
            else if (registerRequest.roles.contains(p0.text.toString()))
                registerRequest.roles -= p0.text.toString()
        }


    fun doRegister() {

        viewModelScope.launch {
            registerUseCase(registerRequest).collect {

                registerStatus.postValue(it)
            }


        }


    }


}
