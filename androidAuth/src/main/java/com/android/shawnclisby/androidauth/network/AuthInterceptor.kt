package com.android.shawnclisby.androidauth.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    private val fakeToken =
        ""

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("x-auth-token", fakeToken)
            .build()

        return chain.proceed(request)
    }
}