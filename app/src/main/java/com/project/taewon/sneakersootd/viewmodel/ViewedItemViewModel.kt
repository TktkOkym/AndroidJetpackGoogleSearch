package com.project.taewon.sneakersootd.viewmodel

import androidx.lifecycle.ViewModel
import com.project.taewon.sneakersootd.repository.SearchRepository
import javax.inject.Inject

class ViewedItemViewModel @Inject constructor(var searchRepository: SearchRepository) : ViewModel() {
    fun getViewedItemFromDb() = searchRepository.getItemListFromDb()
}