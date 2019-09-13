package com.project.taewon.googlesearch.di

import android.app.Application
import com.project.taewon.googlesearch.AppApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, AppModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AppApplication)
}