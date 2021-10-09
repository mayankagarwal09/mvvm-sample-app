package com.example.mvvmsampleapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "items")
@JsonClass(generateAdapter = true)
data class Item(
    val name: String,
    val price: String,
    val extra: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
