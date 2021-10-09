package com.example.mvvmsampleapp.di.module

import com.example.mvvmsampleapp.api.ItemApiService
import com.example.mvvmsampleapp.db.ItemsDao
import com.example.mvvmsampleapp.repositories.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideItemRepository(dao: ItemsDao, itemApiService: ItemApiService): ItemRepository {
        return ItemRepository(dao, itemApiService)
    }
}