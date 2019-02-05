package com.project.taewon.sneakersootd.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.project.taewon.sneakersootd.network.ds.ImagePositionalDataSource
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.view.viewmodel.OotdImageViewModel


class ImageListDataFactory(
    private val networkModel: OotdImageViewModel,
    private val query: String
) : DataSource.Factory<Int, Image>() {

    val mutableLiveData: MutableLiveData<ImagePositionalDataSource>
    private var imagePositionalDataSource: ImagePositionalDataSource? = null

    init {
        this.mutableLiveData = MutableLiveData()
    }

    override fun create(): DataSource<Int, Image> {
        imagePositionalDataSource = ImagePositionalDataSource(networkModel, query)
        mutableLiveData.postValue(imagePositionalDataSource)
        return imagePositionalDataSource as ImagePositionalDataSource
    }
}