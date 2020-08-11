package com.kpa.demo.data.http

import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 */
object ServiceCreator {
    private val okHttpClient by lazy { OkHttpClient().newBuilder() }
    private val retrofit: Retrofit by lazy {
        val builder = Retrofit.Builder()
            .baseUrl("https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(ScalarsConverterFactory.create())
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(com.kpa.demo.data.http.interceptor.HttpLoggingInterceptor())
            .dispatcher(dispatcher)
        builder.client(okHttpClient.build()).build()
    }

    fun <T> create(clazz: Class<T>): T = retrofit.create(clazz)

    inline fun <reified T> createService(clazz: Class<T>): T =
        create(clazz)

}