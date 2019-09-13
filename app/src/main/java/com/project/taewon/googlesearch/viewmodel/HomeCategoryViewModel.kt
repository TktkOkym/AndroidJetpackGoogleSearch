package com.project.taewon.googlesearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.taewon.googlesearch.network.response.TabInfoResponse
import com.project.taewon.googlesearch.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeCategoryViewModel @Inject constructor(private var repository: HomeRepository) : ViewModel() {
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    private val _tabInfoLiveData: MutableLiveData<TabInfoResponse> = MutableLiveData()

    val tabInfoLiveData: LiveData<TabInfoResponse> get() = _tabInfoLiveData

    fun requestTabInfo() {
        if (_tabInfoLiveData.value == null) {
            ioScope.launch { _tabInfoLiveData.postValue(repository.getTabInfo()) }
        }
    }
}