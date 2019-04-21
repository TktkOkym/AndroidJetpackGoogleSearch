package com.project.taewon.sneakersootd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.taewon.sneakersootd.factory.ImageListDataFactory
import com.project.taewon.sneakersootd.network.model.SearchResponse
import com.project.taewon.sneakersootd.network.Resource
import com.project.taewon.sneakersootd.network.model.Image
import com.project.taewon.sneakersootd.repository.SearchRepository
import retrofit2.Call
import java.util.concurrent.Executors
import javax.inject.Inject

class OotdImageViewModel @Inject constructor(var searchRepository: SearchRepository) : ViewModel() {
    lateinit var pagedItems: LiveData<PagedList<Image>>

    fun getSearchImageLiveData(
        query: String,
        searchType: String,
        offset: Int
    ): LiveData<Resource<SearchResponse>> {
        return searchRepository.getSearchImageLiveData(query, searchType, offset)
    }

    fun getSearchImage(
        query: String,
        searchType: String,
        offset: Int
    ): Call<SearchResponse> {
        return searchRepository.getSearchImage(query, searchType, offset)
    }

    private val config = PagedList.Config.Builder()
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPageSize(PAGE_SIZE)
        .setPrefetchDistance(PRE_FETCH_DISTANCE)
        .setEnablePlaceholders(true)
        .build()

    fun setPagedList(query: String) {
        pagedItems = LivePagedListBuilder(ImageListDataFactory(this, query), config)
            .setFetchExecutor(Executors.newFixedThreadPool(NUMBER_OF_THREADS))
            .build()
    }

    companion object {
        const val INITIAL_LOAD_SIZE_HINT = 20
        const val PAGE_SIZE = 10
        const val PRE_FETCH_DISTANCE = 5
        const val NUMBER_OF_THREADS = 5
    }
}