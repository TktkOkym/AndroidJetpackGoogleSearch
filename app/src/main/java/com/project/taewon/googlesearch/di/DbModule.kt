package com.project.taewon.googlesearch.di

import android.app.Application
import androidx.room.Room
import com.project.taewon.googlesearch.db.ItemDatabase
import com.project.taewon.googlesearch.db.dao.ItemListDao
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