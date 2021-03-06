package com.project.taewon.googlesearch.repository

import com.project.taewon.googlesearch.BuildConfig
import com.project.taewon.googlesearch.db.dao.ItemListDao
import com.project.taewon.googlesearch.db.tables.ImageItem
import com.project.taewon.googlesearch.network.response.SearchResponse
import com.project.taewon.googlesearch.network.ApiServices
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject
constructor(private val services: ApiServices, private val itemListDao: ItemListDao) {

    suspend fun getSearchImage(query: String, searchType: String, offset: Int): Response<SearchResponse> {
        return services.getSearchImageAsync(BuildConfig.API_KEY, BuildConfig.CX_ID, query, searchType, offset, 0).await()
    }

    // For Room DB
    fun getItemListFromDb() = itemListDao.getAllSneakers()
    fun insertItemToDb(item: ImageItem) = itemListDao.insert(item)
    fun deleteAllFromDb() = itemListDao.deleteAll()
}