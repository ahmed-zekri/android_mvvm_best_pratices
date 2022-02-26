package com.example.android_mvvm_best_pratices.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.android_mvvm_best_pratices.data.dto.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertMovie(movie: Movie)

    @Query("SELECT * FROM MOVIE ORDER BY id asc")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT COUNT() FROM MOVIE WHERE title=:title")
    suspend fun count(title: String?): Int

    @Query("DELETE  FROM MOVIE WHERE title=:title")
    suspend fun deleteMovie(title: String?): Int
}