package com.project.taewon.sneakersootd.repository

import android.content.Context
import android.content.res.AssetManager
import com.google.gson.Gson
import com.project.taewon.sneakersootd.model.SneakersItemList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class HomeRepository @Inject constructor(private val application: Context) {
    fun getTransactionList(brandName: String): SneakersItemList {
        val jsonString = application.assets.readAssetsFile("$brandName.json")
        return Gson().fromJson(jsonString, SneakersItemList::class.java)
    }

    private fun AssetManager.readAssetsFile(fileName: String): String = open(fileName).bufferedReader().use { it.readText() }
}