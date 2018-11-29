package com.project.taewon.sampledagger.di

import com.project.taewon.sampledagger.network.ApiServices
import com.project.taewon.sampledagger.network.RetrofitBuilderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideWebService(): ApiServices { return RetrofitBuilderFactory.getApiService() }
}