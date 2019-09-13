package com.project.taewon.googlesearch.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.taewon.googlesearch.viewmodel.HomeCategoryViewModel
import com.project.taewon.googlesearch.viewmodel.OotdImageViewModel
import com.project.taewon.googlesearch.viewmodel.ViewedItemViewModel
import com.project.taewon.googlesearch.viewmodel.factory.ViewModelFactory
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