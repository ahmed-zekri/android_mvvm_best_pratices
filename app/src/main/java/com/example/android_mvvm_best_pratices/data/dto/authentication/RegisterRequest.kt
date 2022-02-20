package com.example.android_mvvm_best_pratices.data.dto.authentication

data class RegisterRequest(

    var username: String = "",


    var password: String = "",

    var email: String = "",


    var roles: List<String> = listOf(),


    )