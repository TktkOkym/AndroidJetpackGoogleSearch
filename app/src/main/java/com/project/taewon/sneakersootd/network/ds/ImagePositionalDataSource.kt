package com.project.taewon.sneakersootd.network.ds

import androidx.paging.PositionalDataSource
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel


class ImagePositionalDataSource(
    private val networkModel: OotdImageViewModel,
    val query: String
) : PositionalDataSource<Image>() {
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Image>) {
        val firstLoadPosition = 1 //Google Custom Search API's initial offset start from 1
        val totalCount = computeCount()
        val position = computeInitialLoadPosition(params, totalCount)
        val call =
            networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = firstLoadPosition)
        val response = call.execute()
        if (response.isSuccessful && !response.body()?.items.isNullOrEmpty()) {
            callback.onResult(response?.body()?.items!!, position, totalCount)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Image>) {
        //Google Custom Search API's page offset start from 1, 11, 21... and so on
        val offset = if (params.startPosition >=10) params.startPosition+1 else 1
        val call =
            networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = offset)
        val response = call.execute()
        if (response.isSuccessful && !response.body()?.items.isNullOrEmpty()) {
            callback.onResult(response?.body()?.items!!)
        }
    }

    private fun computeCount(): Int {
        return 50
    }
}