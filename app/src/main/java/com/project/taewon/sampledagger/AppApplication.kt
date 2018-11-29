package com.project.taewon.sampledagger

import android.app.Activity
import android.app.Application
import com.project.taewon.sampledagger.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
    }

    override fun activityInjector() = dispatchingAndroidInjector

    private fun initDagger() {
        AppInjector().init(this)
    }
}