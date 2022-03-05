package com.example.android_mvvm_best_pratices.data.remote.dto.authentication

data class LoginResponse(

    var token: String = "",


    var roles: List<String> = listOf(),
    var type: String = "",


    )