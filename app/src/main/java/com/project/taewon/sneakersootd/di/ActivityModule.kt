package com.project.taewon.sneakersootd.di

import com.project.taewon.sneakersootd.view.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity(): HomeActivity
}