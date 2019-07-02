package com.project.taewon.sneakersootd.viewmodel

import androidx.lifecycle.ViewModel
import com.project.taewon.sneakersootd.repository.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewedItemViewModel @Inject constructor(private var searchRepository: SearchRepository) : ViewModel() {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun getViewedItemFromDb() = searchRepository.getItemListFromDb()

    fun deleteAllFromDb() {
        ioScope.launch { searchRepository.deleteAllFromDb() }
    }
}