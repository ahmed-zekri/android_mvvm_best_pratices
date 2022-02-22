package com.example.android_mvvm_best_pratices.data.dto

import com.example.android_mvvm_best_pratices.ui.component.base.AdapterListItem

data class Movie(
    override var id: Long? = null, var episodes: Int?,

    var title: String?,
    var rating: Float?,
    var isFavourite: Boolean? = false
) : AdapterListItem
