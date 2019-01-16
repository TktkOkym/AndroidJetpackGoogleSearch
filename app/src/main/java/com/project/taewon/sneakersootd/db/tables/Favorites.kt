package com.project.taewon.sneakersootd.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
@JvmSuppressWildcards
data class Favorites(
    @PrimaryKey
    var index: Int,
    var title: String,
    var url: String
)
