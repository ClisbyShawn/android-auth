package com.android.shawnclisby.androidauth.network

import com.android.shawnclisby.androidauth.network.endpoints.AuthService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object HTTP {

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .build()

    val client = retrofit.create(AuthService::class.java)
}