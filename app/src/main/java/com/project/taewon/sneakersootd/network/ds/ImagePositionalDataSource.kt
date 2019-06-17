package com.project.taewon.sneakersootd.network.ds

import androidx.paging.PositionalDataSource
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.db.tables.ImageItem
import com.project.taewon.sneakersootd.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ImagePositionalDataSource(
    private val repository: SearchRepository,
    private val query: String
) : PositionalDataSource<ImageItem>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ImageItem>) {
        val firstLoadPosition = 1 //Google Custom Search API's initial offset start from 1
        //TODO: confirm if this implementation is proper
        runBlocking (Dispatchers.IO) {
            launch {
                val response =
                    repository.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = firstLoadPosition)
                if (response.isSuccessful) {
                    response.body()?.let { searchResponse ->
                        val imageItemList =
                            response.body()?.items?.map { ImageItem(it.title.orEmpty(), it.link.orEmpty(), false)}.orEmpty()
                        callback.onResult(imageItemList,
                        0, // initial index position
                        searchResponse.searchInformation?.totalResults?.toInt() ?: (searchResponse.items?.size ?: 0)) // set placeholder with total count
                    }
                }
            }
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ImageItem>) {
        //Google Custom Search API's page offset start from 1, 11, 21... and so on
        val offset = if (params.startPosition >=10) params.startPosition+1 else 1
        runBlocking (Dispatchers.IO) {
            launch {
                val response =
                    repository.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = offset)
                val imageItemList =
                    response.body()?.items?.map { ImageItem(it.title.orEmpty(), it.link.orEmpty(), false)}.orEmpty()
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onResult(imageItemList) // set placeholder with total count
                    }
                }
            }
        }
    }
}