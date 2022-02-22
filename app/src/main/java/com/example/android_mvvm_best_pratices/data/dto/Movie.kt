package com.example.android_mvvm_best_pratices.data.dto

import com.example.android_mvvm_best_pratices.ui.component.base.AdapterListItem

data class Movie(
    override var id: Long? = null, var episodes: Int,

    var title: String,
    val rating: Float = 0f,
    val isFavourite: Boolean = false
) : AdapterListItem
