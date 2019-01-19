package com.project.taewon.sneakersootd.network

import androidx.lifecycle.LiveData
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.network.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(WebServiceConstants.GET_MAIN)
    fun searchImage(
        @Query("key") apiKey: String,
        @Query("cx") cx: String,
        @Query("q") query: String,
        @Query("searchType") searchType: String,
        @Query("startIndex") offset: Int
    ): LiveData<ApiResponse<SearchResponse>>

    @GET(WebServiceConstants.GET_MAIN)
    fun searchImageNonLiveData(
        @Query("key") apiKey: String,
        @Query("cx") cx: String,
        @Query("q") query: String,
        @Query("searchType") searchType: String,
        @Query("startIndex") offset: Int
    ): Call<SearchResponse>
}
