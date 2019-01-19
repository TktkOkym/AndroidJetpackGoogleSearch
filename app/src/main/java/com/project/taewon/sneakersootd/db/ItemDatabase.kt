package com.project.taewon.sneakersootd.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.taewon.sneakersootd.db.dao.ItemListDao
import com.project.taewon.sneakersootd.db.tables.SneakersItem

@Database(entities = arrayOf(
    SneakersItem::class), version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemListDao(): ItemListDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "Item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}