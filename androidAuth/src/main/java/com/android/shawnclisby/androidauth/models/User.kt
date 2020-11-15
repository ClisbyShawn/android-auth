package com.android.shawnclisby.androidauth.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    val email: String,
    val name: String,
    @Json(name = "_id") val id: String? = null,
    @Json(name = "meta_data") val metaData: UserMetaData? = null
)