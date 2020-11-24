package com.android.shawnclisby.androidauth.network

import android.content.Context
import com.android.shawnclisby.androidauth.network.data.TokenDataSource
import com.android.shawnclisby.androidauth.repo.TokenRepository

object TokenEntry {

    private lateinit var tokenRepository: TokenRepository
    private var tokenKey: String = ""

    fun init(applicationContext: Context, fileName: String, key: String) {
        tokenKey = key
        tokenRepository = TokenRepository(
            TokenDataSource(
                applicationContext,
                fileName,
                tokenKey
            )
        )
    }

    fun onToken(token: String) {
        tokenRepository.onToken(token)
    }

    fun getToken(): String {
        return tokenRepository.getToken(tokenKey)
    }

    fun remove() {
        tokenRepository.removeToken(tokenKey)
    }
}