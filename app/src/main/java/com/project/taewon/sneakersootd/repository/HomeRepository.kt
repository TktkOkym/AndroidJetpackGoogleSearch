package com.project.taewon.sneakersootd.repository

import android.app.Application
import android.content.res.AssetManager
import com.google.gson.Gson
import com.project.taewon.sneakersootd.network.response.TabInfoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val application: Application) {
    fun getTabInfo(): TabInfoResponse {
        val jsonString = application.assets.readAssetsFile("tab_info.json")
        return Gson().fromJson(jsonString, TabInfoResponse::class.java)
    }

    private fun AssetManager.readAssetsFile(fileName: String): String = open(fileName).bufferedReader().use { it.readText() }
}