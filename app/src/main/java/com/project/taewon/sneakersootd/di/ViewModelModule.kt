package com.project.taewon.sneakersootd.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.taewon.sneakersootd.viewmodel.HomeCategoryViewModel
import com.project.taewon.sneakersootd.viewmodel.OotdImageViewModel
import com.project.taewon.sneakersootd.viewmodel.ViewedItemViewModel
import com.project.taewon.sneakersootd.viewmodel.factory.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

/**
 * This class is responsible to inform dagger below viewmodel will support injection.
 * Any new viewmodel which require injection support should be listed in this file. otherwise inject will not work.
 */
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(OotdImageViewModel::class)
    abstract fun bindOotdImageViewModel(ootdImageViewModel: OotdImageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewedItemViewModel::class)
    abstract fun bindViewedItemViewModel(viewedItemViewModel: ViewedItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeCategoryViewModel::class)
    abstract fun bindHomeCategoryViewModel(homeCategoryViewModel: HomeCategoryViewModel): ViewModel
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)