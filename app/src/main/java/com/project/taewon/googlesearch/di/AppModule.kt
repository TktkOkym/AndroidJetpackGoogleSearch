package com.project.taewon.googlesearch.di

import com.project.taewon.googlesearch.network.ApiServices
import com.project.taewon.googlesearch.network.RetrofitBuilderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, DbModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideWebService(): ApiServices { return RetrofitBuilderFactory.getApiServices() }
}