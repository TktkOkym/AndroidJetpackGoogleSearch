package com.project.taewon.sneakersootd.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.project.taewon.sneakersootd.network.ds.ImagePositionalDataSource
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.repository.SearchRepository


class ImageListDataFactory(
    private val repository: SearchRepository,
    private val query: String
) : DataSource.Factory<Int, Image>() {

    private val mutableLiveData = MutableLiveData<ImagePositionalDataSource>()
    private lateinit var imagePositionalDataSource: ImagePositionalDataSource

    override fun create(): DataSource<Int, Image> {
        imagePositionalDataSource = ImagePositionalDataSource(repository, query)
        mutableLiveData.postValue(imagePositionalDataSource)
        return imagePositionalDataSource
    }
}