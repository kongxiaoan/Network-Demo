package com.kpa.demo.data.repository

import com.kpa.demo.data.api.ApiHelper

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getGirls() = apiHelper.getGirls()
}