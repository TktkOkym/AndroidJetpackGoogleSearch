package com.project.taewon.sneakersootd.network.ds

import androidx.paging.PositionalDataSource
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ImagePositionalDataSource(
    private val repository: SearchRepository,
    private val query: String
) : PositionalDataSource<Image>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Image>) {
        val firstLoadPosition = 1 //Google Custom Search API's initial offset start from 1
        //TODO: confirm if this implementation is proper
        runBlocking (Dispatchers.IO) {
            launch {
                val response =
                    repository.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = firstLoadPosition)
                callback.onResult(response.items.orEmpty(),
                    0, // initial index position
                    response.searchInformation?.totalResults?.toInt() ?: (response.items?.size ?: 0)) // set placeholder with total count
            }
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Image>) {
        //Google Custom Search API's page offset start from 1, 11, 21... and so on
        val offset = if (params.startPosition >=10) params.startPosition+1 else 1
        runBlocking (Dispatchers.IO) {
            launch {
                val response =
                    repository.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = offset)
                callback.onResult(response.items.orEmpty()) // set placeholder with total count
            }
        }
    }
}