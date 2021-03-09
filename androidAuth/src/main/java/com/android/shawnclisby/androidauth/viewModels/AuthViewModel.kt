package com.android.shawnclisby.androidauth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shawnclisby.androidauth.models.Session
import com.android.shawnclisby.androidauth.models.SessionFactory
import com.android.shawnclisby.androidauth.network.AuthHTTP
import com.android.shawnclisby.androidauth.network.TokenEntry
import com.android.shawnclisby.androidauth.network.handler.AuthResponseHandler
import com.android.shawnclisby.androidauth.repo.AuthRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authRepo = AuthRepository(AuthHTTP, AuthResponseHandler())

    private val _session: MutableLiveData<Session?> = MutableLiveData(null)
    val session: LiveData<Session?> = _session

    private val authChannel = Channel<AuthEvent>()
    val authFlow = authChannel.receiveAsFlow()

    fun login(credentials: Map<String, String>) = viewModelScope.launch(IO) {
        val resource = authRepo.login(credentials)
        resource.data?.let { token ->
            TokenEntry.onToken(token)
            authChannel.send(AuthEvent.LoginSuccess())
        }

        resource.message?.let { error ->
            authChannel.send(AuthEvent.LoginError(errorMessage = error))
        }
    }

    fun me() = viewModelScope.launch(IO) {
        val resource = authRepo.me()
        resource.data?.let { user ->
            _session.postValue(SessionFactory.create(user))
        }
    }


    fun logout() {
        authRepo.logout()
        _session.value?.logout()
    }

    sealed class AuthEvent {
        data class LoginSuccess(val success: Boolean = true) : AuthEvent()
        data class LoginError(val success: Boolean = false, val errorMessage: String) : AuthEvent()
    }
}