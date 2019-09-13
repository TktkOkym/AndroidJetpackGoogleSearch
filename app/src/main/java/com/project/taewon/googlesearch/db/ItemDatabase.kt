package com.project.taewon.googlesearch.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.taewon.googlesearch.db.dao.ItemListDao
import com.project.taewon.googlesearch.db.tables.ImageItem

@Database(entities = [ImageItem::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemListDao(): ItemListDao
}