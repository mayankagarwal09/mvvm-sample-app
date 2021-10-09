package com.example.mvvmsampleapp.api

import com.example.mvvmsampleapp.models.ApiResponse
import retrofit2.http.GET

interface ItemApiService {
    @GET("v3/b6a30bb0-140f-4966-8608-1dc35fa1fadc")
    suspend fun loadItems(): ApiResponse
}
