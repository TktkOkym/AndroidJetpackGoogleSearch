package com.project.taewon.sneakersootd.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.project.taewon.sneakersootd.db.tables.ImageItem

import com.project.taewon.sneakersootd.repository.SearchRepository


class ImageListDataFactory(
    private val repository: SearchRepository,
    private val query: String
) : DataSource.Factory<Int, ImageItem>() {

    private val mutableLiveData = MutableLiveData<ImagePositionalDataSource>()
    private lateinit var imagePositionalDataSource: ImagePositionalDataSource

    override fun create(): DataSource<Int, ImageItem> {
        imagePositionalDataSource = ImagePositionalDataSource(repository, query)
        mutableLiveData.postValue(imagePositionalDataSource)
        return imagePositionalDataSource
    }
}