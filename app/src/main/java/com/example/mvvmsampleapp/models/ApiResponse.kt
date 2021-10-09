package com.example.mvvmsampleapp.models

data class ApiResponse(
    val status: String,
    val error: String?,
    val data: ItemCollection
)

data class ItemCollection(
    val items: List<Item>
)
