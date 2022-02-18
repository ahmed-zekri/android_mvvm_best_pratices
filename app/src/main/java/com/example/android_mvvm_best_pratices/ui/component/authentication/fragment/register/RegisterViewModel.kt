package com.example.android_mvvm_best_pratices.ui.component.authentication.fragment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.dto.authentication.RegisterRequest
import com.example.android_mvvm_best_pratices.data.dto.user.User
import com.example.android_mvvm_best_pratices.ui.component.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val dataRepository: DataRepository) :
    BaseViewModel() {
    val registerRequest = RegisterRequest()
    val registerStatus = MutableLiveData<Resource<User>>()


    init {
        registerStatus.postValue(Resource.Idle())
    }

    fun doRegister() {
        registerStatus.postValue(Resource.Loading())
        viewModelScope.launch {
            dataRepository.doRegister(registerRequest).collect {

                registerStatus.postValue(it)
            }


        }


    }


}
