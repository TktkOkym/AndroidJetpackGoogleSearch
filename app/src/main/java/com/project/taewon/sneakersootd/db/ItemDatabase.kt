package com.project.taewon.sneakersootd.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.taewon.sneakersootd.db.dao.ItemListDao
import com.project.taewon.sneakersootd.db.tables.ImageItem

@Database(entities = [ImageItem::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemListDao(): ItemListDao
}