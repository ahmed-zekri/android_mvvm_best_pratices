package com.example.android_mvvm_best_pratices.data.dto

import com.example.android_mvvm_best_pratices.ui.component.base.AdapterListItem

class Movie(override val id: Long) : AdapterListItem {
    val episode: Int = 0

    val title: String = ""
    val rating: Float = 0f
    val favourite: Boolean = false

}
