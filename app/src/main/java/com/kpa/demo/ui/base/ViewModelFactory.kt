package com.kpa.demo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kpa.demo.data.api.ApiHelper
import com.kpa.demo.data.repository.MainRepository
import com.kpa.demo.ui.main.viewmodel.MainViewModel

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                MainRepository(apiHelper)
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}