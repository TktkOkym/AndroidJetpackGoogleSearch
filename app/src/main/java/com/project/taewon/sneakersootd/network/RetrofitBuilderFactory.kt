package com.project.taewon.sneakersootd.network

import androidx.annotation.NonNull
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
class RetrofitBuilderFactory {

    @NonNull
    private fun getLiveDataApiServices(): ApiServices {
        val builder = OkHttpClient().newBuilder()
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(WebServiceConstants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build().create(ApiServices::class.java)
    }

    @NonNull
    private fun getApiServices(): ApiServices {
        val builder = OkHttpClient().newBuilder()
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(WebServiceConstants.BASE_URL)
            .client(client)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiServices::class.java)
    }

    companion object {
        /**
         * This method will call using inject, which will maintain single instance
         */
        fun getLiveDataApiServices(): ApiServices {
            return RetrofitBuilderFactory().getLiveDataApiServices()
        }

        fun getApiServices(): ApiServices {
            return RetrofitBuilderFactory().getApiServices()
        }
    }
}