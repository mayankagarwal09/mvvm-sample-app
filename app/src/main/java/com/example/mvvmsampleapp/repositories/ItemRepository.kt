package com.example.mvvmsampleapp.repositories

import com.example.mvvmsampleapp.api.ItemApiService
import com.example.mvvmsampleapp.db.ItemsDao
import com.example.mvvmsampleapp.models.ApiResponse
import com.example.mvvmsampleapp.models.Item
import com.example.mvvmsampleapp.utils.NetworkBoundResource
import com.example.mvvmsampleapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val itemsDao: ItemsDao,
    private val itemService: ItemApiService
) {

    fun loadItemList(): Flow<Resource<List<Item>>> {
        return object : NetworkBoundResource<List<Item>, ApiResponse>() {
            override suspend fun saveRemoteData(response: ApiResponse) {
                if (response.status == "success") {
                    itemsDao.addItems(response.data.items)
                }
            }

            override fun shouldFetch(data: List<Item>?): Boolean =
                data == null || data.isEmpty()

            override fun fetchFromLocal(): Flow<List<Item>> =
                itemsDao.getAllItems()

            override suspend fun fetchFromRemote(): ApiResponse =
                itemService.loadItems()

        }.asFlow()
    }
}