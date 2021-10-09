package com.example.mvvmsampleapp.repositories

import com.example.mvvmsampleapp.api.ItemApi
import com.example.mvvmsampleapp.models.ApiResponse

class ItemRepository {
    suspend fun loadItemList(): ApiResponse {
        return ItemApi.retrofitService.loadItems()
    }
}