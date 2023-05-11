package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _isNext = MutableLiveData<Boolean>()
    val isNext: LiveData<Boolean>
        get() = _isNext

    fun doNext() {
        _isNext.value = true
    }

    fun doNextCompleted() {
        _isNext.value = false
    }
}