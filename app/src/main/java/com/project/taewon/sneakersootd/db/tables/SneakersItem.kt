package com.project.taewon.sneakersootd.db.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sneakers_item")
data class SneakersItem(
    @PrimaryKey
    var title: String
)
