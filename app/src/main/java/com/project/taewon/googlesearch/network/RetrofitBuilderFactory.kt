package com.project.taewon.googlesearch.network

import androidx.annotation.NonNull
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.project.taewon.googlesearch.constants.WebServiceConstants
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
            .baseUrl(WebServiceConstants.BASE_URL)
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiServices::class.java)
    }

    companion object {
        fun getApiServices(): ApiServices {
            return RetrofitBuilderFactory().getApiServices()
        }
    }
}