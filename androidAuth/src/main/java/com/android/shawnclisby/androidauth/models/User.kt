package com.android.shawnclisby.androidauth.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    val credentials: Map<String, String>,
    @Json(name = "meta_data") val metaData: UserMetaData? = null
)