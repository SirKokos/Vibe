package ru.sfedu.vibe.data

import androidx.annotation.DrawableRes

data class DataFriend(
    @DrawableRes val imageId: Int,
    val title: String,
    val status: String
)
