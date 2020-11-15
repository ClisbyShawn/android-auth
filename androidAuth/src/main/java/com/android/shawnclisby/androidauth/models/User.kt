package com.android.shawnclisby.androidauth.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User(
    @Transient val credentials: Map<String, String> = mapOf(),
    val email: String = credentials["email"].toString(),
    val password: String = credentials["password"].toString(),
    @Json(name = "_id") val id: String? = null,
    @Json(name = "meta_data") val metaData: UserMetaData? = null
)