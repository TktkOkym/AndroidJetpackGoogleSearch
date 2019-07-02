package com.project.taewon.sneakersootd.repository

import com.project.taewon.sneakersootd.BuildConfig
import com.project.taewon.sneakersootd.db.dao.ItemListDao
import com.project.taewon.sneakersootd.db.tables.ImageItem
import com.project.taewon.sneakersootd.network.response.SearchResponse
import com.project.taewon.sneakersootd.network.ApiServices
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