package com.android.shawnclisby.androidauth.network.endpoints

import com.android.shawnclisby.androidauth.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    fun login(@Body user:User):String

    @GET("auth/me")
    fun me()
}