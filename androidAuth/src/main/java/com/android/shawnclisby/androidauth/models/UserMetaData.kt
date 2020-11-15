package com.android.shawnclisby.androidauth.models

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class UserMetaData(val joined: Date)