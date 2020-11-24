package com.android.shawnclisby.androidauth.network.data

import android.content.Context

class TokenDataSource(context: Context, fileName: String, private val key: String) :
    DataSource<String> {

    private val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    override fun saveItem(dataItem: String) {
        sharedPref.edit().apply {
            putString(key, dataItem)
            apply()
        }
    }

    override fun getItem(query: String): String {
        return sharedPref.getString(key, "") ?: ""
    }

    override fun removeItem(query: String) {
        sharedPref.edit().apply {
            remove(key)
            apply()
        }
    }
}