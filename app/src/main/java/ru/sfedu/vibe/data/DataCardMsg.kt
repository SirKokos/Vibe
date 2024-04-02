package ru.sfedu.vibe.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DataCardMsg(
    @DrawableRes val imageId: Int,
    val title: String,
    val lastMsg: String
)
