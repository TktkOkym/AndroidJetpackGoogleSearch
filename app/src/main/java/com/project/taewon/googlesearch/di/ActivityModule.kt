package com.project.taewon.googlesearch.di

import com.project.taewon.googlesearch.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): HomeActivity
}