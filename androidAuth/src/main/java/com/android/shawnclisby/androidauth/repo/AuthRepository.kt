package com.android.shawnclisby.androidauth.repo

import com.android.shawnclisby.androidauth.models.User
import com.android.shawnclisby.androidauth.network.HTTP

class AuthRepository(private val http: HTTP) {

    suspend fun login(credentials: Map<String, String>): String {
        return http.client.login(
            User(credentials)
        )
    }

    suspend fun me(): User {
        return http.client.me()
    }
}