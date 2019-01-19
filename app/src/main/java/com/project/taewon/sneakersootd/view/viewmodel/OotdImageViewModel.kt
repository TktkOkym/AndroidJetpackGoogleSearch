package com.project.taewon.sneakersootd.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.taewon.sneakersootd.network.ApiResponse
import com.project.taewon.sneakersootd.network.model.SearchResponse
import com.project.taewon.sneakersootd.network.Resource
import com.project.taewon.sneakersootd.network.repository.SearchRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class OotdImageViewModel @Inject constructor(var searchRepository: SearchRepository) : ViewModel() {
    fun getSearchImage(
        query: String,
        searchType: String,
        offset: Int
    ): LiveData<Resource<SearchResponse>> {
        return searchRepository.getSearchImage(query, searchType, offset)
    }

    fun getSearchImageNonLiveData(
        query: String,
        searchType: String,
        offset: Int
    ): Call<SearchResponse> {
        return searchRepository.getSearchImageNonLiveData(query, searchType, offset)
    }
}