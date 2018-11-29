package com.project.taewon.sampledagger.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.taewon.sampledagger.model.HomeResponse
import com.project.taewon.sampledagger.network.Resource
import com.project.taewon.sampledagger.repository.HomePageRepository
import javax.inject.Inject

class HomeInfoViewModel @Inject constructor(var homePageRepository: HomePageRepository) : ViewModel() {
    fun getHomeInfo(): LiveData<Resource<List<HomeResponse>>> {
        return homePageRepository.getHomeInfo()
    }
}