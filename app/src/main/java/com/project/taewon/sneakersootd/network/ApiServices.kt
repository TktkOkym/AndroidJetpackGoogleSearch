package com.project.taewon.sneakersootd.network

import androidx.lifecycle.LiveData
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.network.model.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(WebServiceConstants.GET_MAIN)
    fun getSearchImageLiveData(
        @Query("key") apiKey: String,
        @Query("cx") cx: String,
        @Query("q") query: String,
        @Query("searchType") searchType: String,
        @Query("start") offset: Int,
        @Query("startIndex") startIndex: Int
    ): LiveData<ApiResponse<SearchResponse>>

    @GET(WebServiceConstants.GET_MAIN)
    fun getSearchImage(
        @Query("key") apiKey: String,
        @Query("cx") cx: String,
        @Query("q") query: String,
        @Query("searchType") searchType: String,
        @Query("start") offset: Int,
        @Query("startIndex") startIndex: Int
    ): Deferred<Response<SearchResponse>>
}
