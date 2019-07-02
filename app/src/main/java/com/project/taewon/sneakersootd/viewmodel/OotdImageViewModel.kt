package com.project.taewon.sneakersootd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.project.taewon.sneakersootd.db.tables.ImageItem
import com.project.taewon.sneakersootd.factory.ImageListDataFactory
import com.project.taewon.sneakersootd.repository.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import javax.inject.Inject

class OotdImageViewModel @Inject constructor(private var searchRepository: SearchRepository) : ViewModel() {
    lateinit var pagedItems: LiveData<PagedList<ImageItem>>
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    private val config = PagedList.Config.Builder()
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPageSize(PAGE_SIZE)
        .setPrefetchDistance(PRE_FETCH_DISTANCE)
        .setEnablePlaceholders(true)
        .build()

    fun setPagedList(query: String) {
        pagedItems = LivePagedListBuilder(ImageListDataFactory(searchRepository, query), config)
            .setFetchExecutor(Executors.newFixedThreadPool(NUMBER_OF_THREADS))
            .build()
    }

    fun insertItemToDb(item: ImageItem) {
        ioScope.launch {
            searchRepository.insertItemToDb(item)
        }
    }

    companion object {
        const val INITIAL_LOAD_SIZE_HINT = 20
        const val PAGE_SIZE = 10
        const val PRE_FETCH_DISTANCE = 5
        const val NUMBER_OF_THREADS = 5
    }
}