package com.kpa.demo.data.http

import com.kpa.demo.data.api.ApiService

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
object NetWorkHelper {
    val apiService =
        ServiceCreator.createService(ApiService::class.java)
}