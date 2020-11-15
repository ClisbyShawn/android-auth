package com.android.shawnclisby.androidauth.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserMetaData(val joined: Long)