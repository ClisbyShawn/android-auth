package com.android.shawnclisby.androidauth.network.endpoints

import com.android.shawnclisby.androidauth.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    suspend fun login(@Body user: Map<String, String>): Response<String>

    @GET("me")
    suspend fun me(): Response<User>
}