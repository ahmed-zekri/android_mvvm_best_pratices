package com.example.android_mvvm_best_pratices.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.android_mvvm_best_pratices.*
import com.example.android_mvvm_best_pratices.data.remote.authentication.APIAuthService
import com.example.android_mvvm_best_pratices.data.remote.movies.APIMoviesService
import com.example.android_mvvm_best_pratices.data.room.dao.MovieDao
import com.example.android_mvvm_best_pratices.data.room.database.Database
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

private const val timeoutRead = 30   //In seconds
private const val timeoutConnect = 2   //In seconds

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
    fun provideServiceGenerator(
        sharedPreferences: SharedPreferences,
        moshi: Moshi
    ): ServiceGenerator {
        return ServiceGenerator(sharedPreferences, moshi)
    }


    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideSharedPreferencesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
        sharedPreferences.edit()


    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideDao(database: Database): MovieDao = database.movieDao

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: Interceptor,
        logger: HttpLoggingInterceptor,
    ): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(headerInterceptor)
        okHttpBuilder.addInterceptor(logger)
        okHttpBuilder.connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(sharedPreferences: SharedPreferences) = Interceptor { chain ->
        val original = chain.request()

        val request = original.newBuilder()
            .header("Authorization", sharedPreferences.getString(TOKEN_KEY, "")!!)
            .method(original.method, original.body)
            .build()

        chain.proceed(request)
    }

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.apply { level = HttpLoggingInterceptor.Level.BODY }
        }
        return loggingInterceptor

    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit =


        Retrofit.Builder()
            .baseUrl(TEST_BASE_URL).client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): APIAuthService =
        retrofit.create(APIAuthService::class.java)


    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): APIMoviesService =
        retrofit.create(APIMoviesService::class.java)


}