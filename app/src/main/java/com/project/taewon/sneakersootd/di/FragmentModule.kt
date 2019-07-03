package com.project.taewon.sneakersootd.di

import com.project.taewon.sneakersootd.view.fragment.HomeCategoryFragment
import com.project.taewon.sneakersootd.view.fragment.OotdImageListFragment
import com.project.taewon.sneakersootd.view.fragment.ViewedItemFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeOotdImageListFragment(): OotdImageListFragment

    @ContributesAndroidInjector
    abstract fun contributeViewedItemFragment(): ViewedItemFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeCategoryFragment(): HomeCategoryFragment
}