package com.android.shawnclisby.androidauth.network

import com.android.shawnclisby.androidauth.network.endpoints.AuthService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AuthHTTP {

    lateinit var client: AuthService

    fun init(url: String) {

        val moshi: Moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()

        client = retrofit.create(AuthService::class.java)
    }
}