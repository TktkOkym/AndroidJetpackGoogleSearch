package com.project.taewon.sneakersootd.repository

import androidx.lifecycle.LiveData
import com.project.taewon.sneakersootd.BuildConfig
import com.project.taewon.sneakersootd.di.AppExecutors
import com.project.taewon.sneakersootd.network.model.SearchResponse
import com.project.taewon.sneakersootd.network.ApiResponse
import com.project.taewon.sneakersootd.network.ApiServices
import com.project.taewon.sneakersootd.network.NetworkBoundResource
import com.project.taewon.sneakersootd.network.Resource
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject
constructor(private val executors: AppExecutors, private val services: ApiServices) {
    fun getSearchImageLiveData(
        query: String,
        searchType: String,
        offset: Int
    ): LiveData<Resource<SearchResponse>> {
        return object : NetworkBoundResource<SearchResponse>(executors) {
            override fun createCall(): LiveData<ApiResponse<SearchResponse>> {
                return services.getSearchImageLiveData(BuildConfig.API_KEY, BuildConfig.CX_ID, query, searchType, offset, 0)
            }
        }.asLiveData()
    }

    fun getSearchImage(
        query: String,
        searchType: String,
        offset: Int
    ): Call<SearchResponse> {
        return services.getSearchImage(BuildConfig.API_KEY, BuildConfig.CX_ID, query, searchType, offset, 0)
    }
}