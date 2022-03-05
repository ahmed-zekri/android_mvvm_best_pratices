package com.example.android_mvvm_best_pratices.domain.usecase.authentication

import android.content.SharedPreferences
import com.example.android_mvvm_best_pratices.ROLES_KEY
import com.example.android_mvvm_best_pratices.TOKEN_KEY
import com.example.android_mvvm_best_pratices.data.Resource
import com.example.android_mvvm_best_pratices.data.remote.dto.authentication.LoginResponse

import javax.inject.Inject

class SaveAtUseCase @Inject constructor(private val sharedPreferencesEditor: SharedPreferences.Editor) {
    operator fun invoke(resource: Resource.Success<LoginResponse>) {
        sharedPreferencesEditor.putString(
            TOKEN_KEY,
            resource.data?.type + " " + resource.data?.token
        )
        sharedPreferencesEditor.putStringSet(ROLES_KEY, resource.data?.roles?.toSet())
        sharedPreferencesEditor.commit()
    }
}