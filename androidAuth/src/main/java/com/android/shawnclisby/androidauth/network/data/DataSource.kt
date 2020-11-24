package com.android.shawnclisby.androidauth.network.data

interface DataSource<T> {

    fun saveItem(dataItem: T)

    fun getItem(query: String): T

    fun removeItem(query: String)
}