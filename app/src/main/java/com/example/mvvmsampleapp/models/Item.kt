package com.example.mvvmsampleapp.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val name: String,
    val price: String,
    val extra: String?
)
