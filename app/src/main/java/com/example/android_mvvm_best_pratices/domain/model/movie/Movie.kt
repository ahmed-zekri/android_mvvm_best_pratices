package com.example.android_mvvm_best_pratices.domain.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android_mvvm_best_pratices.ui.component.base.AdapterListItem

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    override var id: Int?,
    var episodes: Int?,

    var title: String?,
    var rating: Float?,
    var isFavourite: Boolean? = false
) : AdapterListItem
