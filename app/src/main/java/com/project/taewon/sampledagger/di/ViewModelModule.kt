package com.project.taewon.sampledagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.taewon.sampledagger.view.viewmodel.HomeInfoViewModel
import com.project.taewon.sampledagger.view.viewmodel.factory.ViewModelFactory
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
    @ViewModelKey(HomeInfoViewModel::class)
    abstract fun bindHomeTabInfoViewModel(homeViewModel: HomeInfoViewModel): ViewModel
}

@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)