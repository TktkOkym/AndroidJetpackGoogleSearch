package com.project.taewon.googlesearch.network

import com.project.taewon.googlesearch.constants.WebServiceConstants
import com.project.taewon.googlesearch.network.response.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(WebServiceConstants.GET_MAIN)
    fun getSearchImageAsync(
        @Query("key") apiKey: String,
        @Query("cx") cx: String,
        @Query("q") query: String,
        @Query("searchType") searchType: String,
        @Query("start") offset: Int,
        @Query("startIndex") startIndex: Int
    ): Deferred<Response<SearchResponse>>
}
