package com.project.taewon.sampledagger.network

import androidx.annotation.NonNull
import com.project.taewon.sampledagger.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
class RetrofitBuilderFactory {

    @NonNull
    private fun getApiServices(): ApiServices {
        val builder = OkHttpClient().newBuilder()
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(Constants.WebService.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build().create(ApiServices::class.java)
    }

    companion object {
        /**
         * This method will call using inject, which will maintain single instance
         */
        fun getApiService(): ApiServices {
            return RetrofitBuilderFactory().getApiServices()
        }
    }
}