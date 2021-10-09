package com.example.mvvmsampleapp.di.module

import android.app.Application
import com.example.mvvmsampleapp.db.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = ItemsDatabase.getInstance(application)

    @Singleton
    @Provides
    fun providePostsDao(database: ItemsDatabase) = database.getItemsDao()
}