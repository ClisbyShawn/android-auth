package com.android.shawnclisby.androidauth.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shawnclisby.androidauth.models.User
import com.android.shawnclisby.androidauth.network.AuthHTTP
import com.android.shawnclisby.androidauth.network.handler.AuthResponseHandler
import com.android.shawnclisby.androidauth.network.handler.Resource
import com.android.shawnclisby.androidauth.repo.AuthRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authRepo = AuthRepository(AuthHTTP, AuthResponseHandler())

    private val _token: MutableLiveData<Resource<String?>> = MutableLiveData(Resource.loading(null))
    val token: LiveData<Resource<String?>> = _token

    private val _user: MutableLiveData<Resource<User?>> = MutableLiveData(Resource.loading(null))
    val user: LiveData<Resource<User?>> = _user

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

    fun logout(){
        authRepo.logout()
    }

}