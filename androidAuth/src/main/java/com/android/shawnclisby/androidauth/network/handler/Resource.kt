package com.android.shawnclisby.androidauth.network.handler

import com.android.shawnclisby.androidauth.network.handler.NetworkStatus.*

data class Resource<out T>(val status: NetworkStatus, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String?): Resource<T> {
            return Resource(ERROR, data, message)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}