package com.project.taewon.sneakersootd.di

import com.project.taewon.sneakersootd.view.fragment.HomeCategoryFragment
import com.project.taewon.sneakersootd.view.fragment.OotdImageListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeCategoryFragment(): HomeCategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeOotdImageListFragment(): OotdImageListFragment
}