package com.project.taewon.sneakersootd.network.ds

import android.annotation.SuppressLint
import androidx.lifecycle.Observer
import androidx.paging.PositionalDataSource
import com.project.taewon.sneakersootd.constants.WebServiceConstants
import com.project.taewon.sneakersootd.network.Status
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel


class ImagePositionalDataSource(
    private val networkModel: OotdImageViewModel,
    val query: String
) : PositionalDataSource<Image>() {

    //TODO: 'observe' should be called in a main thread --> need to find out the solution
    @SuppressLint("WrongThread")
    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Image>) {
        val firstLoadPosition = PositionalDataSource.computeInitialLoadPosition(params, computeCount())

//        networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = firstLoadPosition).observe(this, Observer { response ->
//            when (response?.status) {
//                Status.SUCCESS -> {
//                    if (!response.data?.items.isNullOrEmpty()) {
//                        callback.onResult(response.data?.items!!, firstLoadPosition)
//                    }
//                }
//                Status.ERROR -> {
//                }
//                Status.LOADING -> {}
//            }
//        })
    }

    @SuppressLint("WrongThread")
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Image>) {
//        networkModel.getSearchImage(query, WebServiceConstants.SEARCH_TYPE, offset = params.startPosition).observe(this, Observer { response ->
//            when (response?.status) {
//                Status.SUCCESS -> {
//                    if (!response.data?.items.isNullOrEmpty()) {
//                        callback.onResult(response.data?.items!!)
//                    }
//                }
//                Status.ERROR -> {
//                }
//                Status.LOADING -> {}
//            }
//        })
    }

    //TODO:
    private fun computeCount(): Int {
        return 0
    }
}