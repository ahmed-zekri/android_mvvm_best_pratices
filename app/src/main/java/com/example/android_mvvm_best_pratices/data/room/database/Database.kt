package com.example.android_mvvm_best_pratices.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_mvvm_best_pratices.data.dto.Movie
import com.example.android_mvvm_best_pratices.data.room.dao.MovieDao

@Database(entities = [Movie::class], version = 1, exportSchema = true)
abstract class Database : RoomDatabase() {
    abstract val movieDao: MovieDao
}