package com.android.shawnclisby.androidauth.network

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import com.android.shawnclisby.androidauth.BuildConfig

object TokenEntry {
    private lateinit var encryptedSharedPreferences: SharedPreferences

    fun init(applicationContext: Context) {
        encryptedSharedPreferences = EncryptedSharedPreferences.create(
            BuildConfig.SECRET_FILE_NAME,
            BuildConfig.MY_SECRET_KEY,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }

    @Throws(NullPointerException::class)
    fun onToken(token: String) {
        if (::encryptedSharedPreferences.isInitialized) {
            with(encryptedSharedPreferences.edit()) {
                putString(BuildConfig.TOKEN_KEY, token)
                apply()
            }
        } else throw NullPointerException("Call TokenEntry's init method in Application's onCreate method.")
    }

    @Throws(NullPointerException::class)
    fun getToken(): String {
        var token: String = ""
        if (::encryptedSharedPreferences.isInitialized) {
            with(encryptedSharedPreferences) {
                token = getString(BuildConfig.TOKEN_KEY, "") ?: ""
            }

        } else throw NullPointerException("Call TokenEntry's init method in Application's onCreate method.")

        return token
    }

    @Throws(NullPointerException::class)
    fun remove() {
        if (::encryptedSharedPreferences.isInitialized) {
            with(encryptedSharedPreferences.edit()) {
                remove(BuildConfig.TOKEN_KEY)
                apply()
            }
        } else throw NullPointerException("Call TokenEntry's init method in Application's onCreate method.")
    }
}