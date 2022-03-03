package com.example.android_mvvm_best_pratices.domain.model.user

data class User(
    val username: String = "",
    val roles: List<Role> = listOf(),
    val email: String = ""
)
