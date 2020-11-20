package com.android.shawnclisby.androidlibrary

import android.app.Application
import com.android.shawnclisby.androidauth.network.TokenEntry

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        TokenEntry.init(this)
    }
}