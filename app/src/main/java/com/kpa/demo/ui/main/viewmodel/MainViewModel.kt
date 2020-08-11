package com.kpa.demo.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kpa.demo.data.repository.MainRepository
import com.kpa.demo.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception


/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getGirls() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(mainRepository.getGirls()))
        } catch (e: Exception) {
            emit(Resource.error(e.message, null))
        }
    }
}