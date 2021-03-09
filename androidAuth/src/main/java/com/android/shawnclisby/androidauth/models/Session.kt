package com.android.shawnclisby.androidauth.models

import java.util.*

private const val FIRST_NAME_INDEX = 0
private const val LAST_NAME_INDEX = 1

data class Session(
    private val user: User,
    private val loginTimeStamp: Long = Date().time,
    private var logoutTimeStamp: Long? = null
) {
    fun logout() {
        logoutTimeStamp = Date().time
    }

    val userFirstName: String
        get() = user.name.split(" ")[FIRST_NAME_INDEX].trim()

    val userLastName: String
        get() = user.name.split(" ")[LAST_NAME_INDEX].trim()

    val userEmail: String
        get() = user.email

}