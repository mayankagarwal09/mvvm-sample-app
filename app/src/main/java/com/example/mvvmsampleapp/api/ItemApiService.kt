package com.example.mvvmsampleapp.api

import com.example.mvvmsampleapp.models.ApiResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(ItemApi.BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ItemApiService {

    @GET("v3/b6a30bb0-140f-4966-8608-1dc35fa1fadc")
    suspend fun loadItems(): ApiResponse
}

object ItemApi {
    const val BASE_URL = "https://run.mocky.io/"

    val retrofitService: ItemApiService by lazy {
        retrofit.create(ItemApiService::class.java)
    }
}