package com.kpa.demo.data.api

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
class ApiHelper(private val apiService: ApiService) {
    suspend fun getGirls() = apiService.getGirls(1)
}