package com.android.shawnclisby.androidauth.network.handler

class AuthResponseHandler : ResponseHandler() {

    override fun getErrorMessage(code: Int): String {
        return when (code) {
            400 -> "Client request is malformed. JSON Request: { email:String, password:String }"
            401, 404 -> "Invalid Email and Password Combination"
            else -> super.getErrorMessage(code)
        }
    }
}