package com.project.taewon.sampledagger.di

import com.project.taewon.sampledagger.view.fragment.BlankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeBlankFragment(): BlankFragment
}