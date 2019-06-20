package com.project.taewon.sneakersootd.di

import android.app.Application
import androidx.room.Room
import com.project.taewon.sneakersootd.db.ItemDatabase
import com.project.taewon.sneakersootd.db.dao.ItemListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): ItemDatabase = Room.databaseBuilder(app, ItemDatabase::class.java, "item.db").fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideItemDb(db: ItemDatabase): ItemListDao = db.itemListDao()
}