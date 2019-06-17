package com.project.taewon.sneakersootd.di

import com.project.taewon.sneakersootd.network.ApiServices
import com.project.taewon.sneakersootd.network.RetrofitBuilderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, DbModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideWebService(): ApiServices { return RetrofitBuilderFactory.getApiServices() }
}