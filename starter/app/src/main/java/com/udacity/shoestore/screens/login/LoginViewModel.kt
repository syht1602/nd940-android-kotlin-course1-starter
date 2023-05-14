package com.udacity.shoestore.screens.login

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _isLoginSuccess = MutableLiveData<Boolean?>()
    val isLoginSuccess: LiveData<Boolean?>
        get() = _isLoginSuccess

    private val _email = MutableLiveData<String>()
    var email: String
        get() = _email.value ?: ""
        set(value) {
            _email.value = value
        }

    private val _password = MutableLiveData<String>()
    var password: String
        get() = _password.value ?: ""
        set(value) {
            _password.value = value
        }

    fun doLogin() {
        _isLoginSuccess.value = email == "email" && password == "password"
        email = ""
        password = ""
    }

    fun resetLoginState() {
        _isLoginSuccess.value = null
    }

    fun onEmailChanged(editable: Editable){
        _email.value = editable.toString()
    }

    fun onPasswordChanged(editable: Editable){
        _password.value = editable.toString()
    }
}
