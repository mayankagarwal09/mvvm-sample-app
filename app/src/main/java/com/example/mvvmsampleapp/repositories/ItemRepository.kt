package com.example.mvvmsampleapp.repositories

import com.example.mvvmsampleapp.api.ItemApiService
import com.example.mvvmsampleapp.models.ApiResponse
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemService: ItemApiService) {

    suspend fun loadItemList(): ApiResponse {
        return itemService.loadItems()
    }
}