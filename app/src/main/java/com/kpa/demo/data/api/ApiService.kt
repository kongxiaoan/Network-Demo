package com.kpa.demo.data.api

import com.kpa.demo.data.model.Girls
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */

interface ApiService  {
    @GET("{page}")
    suspend fun getGirls(@Path("page") page: Int): Girls
}