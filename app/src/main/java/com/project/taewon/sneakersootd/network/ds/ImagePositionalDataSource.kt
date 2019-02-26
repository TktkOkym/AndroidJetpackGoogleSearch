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
        //TODO:
//        val firstLoadPosition = PositionalDataSource.computeInitialLoadPosition(params, computeCount())
        val firstLoadPosition = 1

        val call =
            networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = firstLoadPosition)
        val response = call.execute()
        if (response.isSuccessful && !response.body()?.items.isNullOrEmpty()) {
            //TODO: fix total count
            callback.onResult(response?.body()?.items!!, firstLoadPosition, 100)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Image>) {

        val offset = if (params.startPosition >=10) params.startPosition+1 else 1
        val call =
            networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = offset)
        val response = call.execute()
        if (response.isSuccessful && !response.body()?.items.isNullOrEmpty()) {
            callback.onResult(response?.body()?.items!!)
        }
    }

    private fun computeCount(): Int {
        return 100
    }
}