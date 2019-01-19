package com.project.taewon.sneakersootd.network.repository

import androidx.lifecycle.LiveData
import com.project.taewon.sneakersootd.BuildConfig
import com.project.taewon.sneakersootd.di.AppExecutors
import com.project.taewon.sneakersootd.network.model.SearchResponse
import com.project.taewon.sneakersootd.network.ApiResponse
import com.project.taewon.sneakersootd.network.ApiServices
import com.project.taewon.sneakersootd.network.NetworkBoundResource
import com.project.taewon.sneakersootd.network.Resource
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject
constructor(private val executors: AppExecutors, private val services: ApiServices) {
    fun getSearchImage(
        query: String,
        searchType: String,
        offset: Int
    ): LiveData<Resource<SearchResponse>> {
        return object : NetworkBoundResource<SearchResponse>(executors) {
            override fun createCall(): LiveData<ApiResponse<SearchResponse>> {
                return services.searchImage(BuildConfig.API_KEY, BuildConfig.CX_ID, query, searchType, offset)
            }
        }.asLiveData()
    }

    fun getSearchImageNonLiveData(
        query: String,
        searchType: String,
        offset: Int
    ): Call<SearchResponse> {
        return services.searchImageNonLiveData(BuildConfig.API_KEY, BuildConfig.CX_ID, query, searchType, offset)
    }
}