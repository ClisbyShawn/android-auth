package com.android.shawnclisby.androidauth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shawnclisby.androidauth.models.User
import com.android.shawnclisby.androidauth.network.HTTP
import com.android.shawnclisby.androidauth.repo.AuthRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authRepo = AuthRepository(HTTP)

    private val _token: MutableLiveData<String> = MutableLiveData()
    val token: LiveData<String> = _token

    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> = _user

    fun login(credentials: Map<String, String>) {
        viewModelScope.launch(IO) {
            _token.postValue(authRepo.login(credentials))
        }
    }

    fun me() {
        viewModelScope.launch(IO) {
            _user.postValue(authRepo.me())
        }
    }

}