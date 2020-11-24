package com.android.shawnclisby.androidauth.repo

import com.android.shawnclisby.androidauth.network.data.DataSource

class TokenRepository(private val dataSource: DataSource<String>) {

    fun onToken(token: String) {
        dataSource.saveItem(token)
    }

    fun getToken(tokenKey: String): String {
        return dataSource.getItem(tokenKey)
    }

    fun removeToken(tokenKey: String) {
        dataSource.removeItem(tokenKey)
    }
}