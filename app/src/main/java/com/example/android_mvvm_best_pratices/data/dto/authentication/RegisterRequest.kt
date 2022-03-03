package com.example.android_mvvm_best_pratices.data.dto.authentication

import com.example.android_mvvm_best_pratices.domain.model.user.Role
import com.example.android_mvvm_best_pratices.domain.model.user.User

data class RegisterRequest(

    var username: String = "",


    var password: String = "",

    var email: String = "",


    var roles: List<String> = listOf(),


    )

fun mapUserToRole(roles: List<String>) = roles.map {
    var value = Role.User
    for (item in Role.values())
        if (it == item.name)
            value = item

    value


}

fun RegisterRequest.toUser() =
    User(username = username, roles = mapUserToRole(roles), email = email)