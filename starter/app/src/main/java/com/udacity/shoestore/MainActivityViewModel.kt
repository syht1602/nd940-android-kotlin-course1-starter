package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _isFabClick = MutableLiveData<Boolean>()
    val isFabClick: LiveData<Boolean>
        get() = _isFabClick

    private val _isLogout = MutableLiveData<Boolean?>()
    val isLogout: LiveData<Boolean?>
        get() = _isLogout

    fun onFabClick() {
        _isFabClick.value = true
    }

    fun onFabClickComplete() {
        _isFabClick.value = false
    }

    fun doLogout() {
        _isLogout.value = true
    }

    fun resetLogoutStatus() {
        _isLogout.value = null
    }

}
