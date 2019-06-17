package com.project.taewon.sneakersootd.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sneakers_item")
data class ImageItem(
    @PrimaryKey
    var title: String,
    var url: String,
    var isLiked: Boolean = false
)
