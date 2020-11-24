package com.android.shawnclisby.androidlibrary

import android.app.Application
import com.android.shawnclisby.androidauth.BuildConfig
import com.android.shawnclisby.androidauth.network.AuthHTTP
import com.android.shawnclisby.androidauth.network.TokenEntry

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        TokenEntry.init(this, BuildConfig.SECRET_FILE_NAME, BuildConfig.TOKEN_KEY)
        AuthHTTP.init(BuildConfig.SECRET_BASE_URL)
    }
}