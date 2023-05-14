package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {
    private val _isNextButtonClick = MutableLiveData<Boolean>()
    val isNextButtonClick: LiveData<Boolean>
        get() = _isNextButtonClick

    fun doNext() {
        _isNextButtonClick.value = true
    }

    fun resetButtonState() {
        _isNextButtonClick.value = false
    }
}
