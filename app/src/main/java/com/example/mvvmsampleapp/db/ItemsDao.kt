package com.example.mvvmsampleapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmsampleapp.models.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItems(items: List<Item>)

    @Query("DELETE FROM items")
    suspend fun deleteAllItems()

    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>
}