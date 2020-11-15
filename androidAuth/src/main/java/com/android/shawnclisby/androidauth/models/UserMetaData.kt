package com.android.shawnclisby.androidauth.models

import com.android.shawnclisby.androidauth.utils.convertStampToMediumDate
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserMetaData(val joined: Long) {
    override fun toString(): String {
        return "\nDate Joined:${joined.convertStampToMediumDate()}"
    }
}