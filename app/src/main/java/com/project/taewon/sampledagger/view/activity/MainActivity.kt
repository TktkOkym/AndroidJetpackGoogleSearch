package com.project.taewon.sampledagger.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.project.taewon.sampledagger.R
import com.project.taewon.sampledagger.network.Status
import com.project.taewon.sampledagger.view.viewmodel.HomeInfoViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getHomeInfoApi()
    }

    private fun getHomeInfoApi() {
        this.let {
            val networkModel =
                    ViewModelProviders.of(this, viewModelFactory).get(HomeInfoViewModel::class.java)
            networkModel.getHomeInfo().observe(this, Observer { response ->
                if (response?.status == Status.SUCCESS && !response.data.isNullOrEmpty()) {
                    // TODO: handle response
                }
            })
        }
    }
}
