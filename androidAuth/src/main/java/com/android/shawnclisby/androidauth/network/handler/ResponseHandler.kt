package com.android.shawnclisby.androidauth.network.handler

import retrofit2.HttpException

/**
 * [ResponseHandler] is an open Kotlin class that
 * calls the instantiation of [Resource] objects.
 * This class also handles error messages that can
 * be overridden to handle specific end point responses.
 * */
open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleFailure(e: Exception): Resource<T> {
        return when (e) {

            is HttpException -> Resource.error(
                data = null,
                message = getErrorMessage(e.code())
            )

            else -> Resource.error(
                null,
                getErrorMessage(Int.MAX_VALUE)
            )
        }
    }

    protected open fun getErrorMessage(code: Int): String {
        return when (code) {
            401 -> "Unauthorized"
            404 -> "Not found"
            else -> "Something went wrong"
        }
    }
}