package com.android.shawnclisby.androidauth.repo

import com.android.shawnclisby.androidauth.models.User
import com.android.shawnclisby.androidauth.network.AuthHTTP
import com.android.shawnclisby.androidauth.network.handler.Resource
import com.android.shawnclisby.androidauth.network.handler.ResponseHandler

class AuthRepository(private val http: AuthHTTP, private val responseHandler: ResponseHandler) {

    suspend fun login(credentials: Map<String, String>): Resource<String?> {
        return try {
            responseHandler.handleSuccess(http.client.login(credentials))
        } catch (e: Exception) {
            responseHandler.handleFailure(e)
        }
    }

    suspend fun me(): Resource<User?> {
        return try {
            responseHandler.handleSuccess(http.client.me())
        } catch (e: Exception) {
            responseHandler.handleFailure(e)
        }
    }
}