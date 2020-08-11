package com.kpa.demo.utils

/**
 *    author : kpa
 *    e-mail : billkp@yeah.net
 *    将网络调用的状态传给UI层
 */
class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)
        fun <T> error(msg: String?, data: T?) = Resource(Status.ERROR, data, msg)
        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
    }
}