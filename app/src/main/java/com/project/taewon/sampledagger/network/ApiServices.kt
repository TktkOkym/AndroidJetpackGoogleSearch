package com.project.taewon.sampledagger.network

import androidx.lifecycle.LiveData
import com.project.taewon.sampledagger.Constants
import com.project.taewon.sampledagger.model.HomeResponse
import retrofit2.http.GET

interface ApiServices {
    @GET(Constants.WebService.GET_MAIN)
    fun getHomePageApi(): LiveData<ApiResponse<List<HomeResponse>>>
}
