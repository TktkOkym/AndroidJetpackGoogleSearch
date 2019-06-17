package com.project.taewon.sneakersootd.di

import com.project.taewon.sneakersootd.db.ItemDatabase
import com.project.taewon.sneakersootd.db.dao.ItemListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideItemDb(db: ItemDatabase): ItemListDao = db.itemListDao()
}