package com.android.shawnclisby.androidauth.repo

import com.android.shawnclisby.androidauth.models.User
import com.android.shawnclisby.androidauth.network.AuthHTTP
import com.android.shawnclisby.androidauth.network.TokenEntry
import com.android.shawnclisby.androidauth.network.handler.Resource
import com.android.shawnclisby.androidauth.network.handler.ResponseHandler
import retrofit2.HttpException

class AuthRepository(private val http: AuthHTTP, private val responseHandler: ResponseHandler) {

    suspend fun login(credentials: Map<String, String>): Resource<String?> {
        return try {
            val response = http.client.login(credentials)
            val result = response.body()
            if (response.isSuccessful && result != null)
                responseHandler.handleSuccess(result)
            else
                responseHandler.handleFailure(HttpException(response))
        } catch (e: Exception) {
            responseHandler.handleFailure(e)
        }
    }

    suspend fun me(): Resource<User?> {
        return try {
            val response = http.client.me()
            val result = response.body()
            if (response.isSuccessful && result != null)
                responseHandler.handleSuccess(result)
            else
                responseHandler.handleFailure(HttpException(response))
        } catch (e: Exception) {
            responseHandler.handleFailure(e)
        }
    }

    fun logout() {
        TokenEntry.remove()
    }
}