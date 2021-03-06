package com.example.android_mvvm_best_pratices.di

import android.content.Context
import com.example.android_mvvm_best_pratices.data.DataRepository
import com.example.android_mvvm_best_pratices.data.remote.RemoteDataSource
import com.example.android_mvvm_best_pratices.data.remote.ServiceGenerator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    fun provideServiceGenerator(): ServiceGenerator {
        return ServiceGenerator()
    }

}