package com.mrwhoknows.ecommerce_mob_app.presentation.ui.user

import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrwhoknows.ecommerce_mob_app.domain.model.UserTokens
import com.mrwhoknows.ecommerce_mob_app.repository.UserRepository
import com.mrwhoknows.ecommerce_mob_app.util.Resource
import kotlinx.coroutines.launch
import java.io.IOException

class UserViewModel
@ViewModelInject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _tokens: MutableLiveData<Resource<UserTokens>> = MutableLiveData()
    val tokens: LiveData<Resource<UserTokens>> = _tokens

    fun loginUser(email: String, password: String) {
        _tokens.postValue(Resource.Loading())
        try {
            viewModelScope.launch {
                val result = repository.userLogin(email, password)
                if (result != null) {
                    _tokens.postValue(Resource.Success(result))
                    println("CSRF = ${result.csrf_token}")
                } else {
                    println("CSRF ERROR")
                    throw Exception("Login Error")
                }
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _tokens.postValue(Resource.Error("Network Error"))
                else -> _tokens.postValue(
                    Resource.Error("Error: ${t.localizedMessage}")
                )
            }
        }
    }

    val username = mutableStateOf("")
    val password = mutableStateOf("")
    fun onUsernameChanged(newValue: String) {
        username.value = newValue
    }

    fun onPasswordChanged(newValue: String) {
        password.value = newValue
    }
}