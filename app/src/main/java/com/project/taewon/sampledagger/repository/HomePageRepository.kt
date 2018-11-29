package com.project.taewon.sampledagger.repository

import androidx.lifecycle.LiveData
import com.project.taewon.sampledagger.di.AppExecutors
import com.project.taewon.sampledagger.model.HomeResponse
import com.project.taewon.sampledagger.network.ApiResponse
import com.project.taewon.sampledagger.network.ApiServices
import com.project.taewon.sampledagger.network.NetworkBoundResource
import com.project.taewon.sampledagger.network.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomePageRepository @Inject
constructor(private val executors: AppExecutors, private val services: ApiServices) {
    fun getHomeInfo(): LiveData<Resource<List<HomeResponse>>> {
        return object : NetworkBoundResource<List<HomeResponse>>(executors) {
            override fun createCall(): LiveData<ApiResponse<List<HomeResponse>>> {
                return services.getHomePageApi()
            }
        }.asLiveData()
    }
}