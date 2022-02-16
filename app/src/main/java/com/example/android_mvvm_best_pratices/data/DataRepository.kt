package com.example.android_mvvm_best_pratices.data

import com.example.android_mvvm_best_pratices.data.dto.RegisterRequest
import com.example.android_mvvm_best_pratices.data.remote.RemoteData
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(
    private val remoteRepository: RemoteData,
    private val ioDispatcher: CoroutineContext
) :
    DataRepositorySource {
    override suspend fun doRegister(registerRequest: RegisterRequest): kotlinx.coroutines.flow.Flow<Any?> {
        return flow {

            emit(remoteRepository.register(registerRequest))

        }.flowOn(ioDispatcher)

    }

}