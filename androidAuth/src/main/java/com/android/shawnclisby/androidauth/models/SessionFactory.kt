package com.android.shawnclisby.androidauth.models

object SessionFactory {

    fun create(user: User): Session = Session(user = user)
}