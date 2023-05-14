package com.udacity.shoestore.screens.shoe_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {
    private val _isSave = MutableLiveData<Boolean>()
    val isSave: LiveData<Boolean>
        get() = _isSave
    private val _isCancel = MutableLiveData<Boolean>()
    val isCancel: LiveData<Boolean>
        get() = _isCancel

    private val _shoeName = MutableLiveData<String>()
    var shoeName: String
        get() = _shoeName.value ?: ""
        set(value) {
            _shoeName.value = value
        }

    private val _shoeCompany = MutableLiveData<String>()
    var shoeCompany: String
        get() = _shoeCompany.value ?: ""
        set(value) {
            _shoeCompany.value = value
        }

    private val _shoeSize = MutableLiveData<String>()
    var shoeSize: String
        get() = _shoeSize.value ?: ""
        set(value) {
            _shoeSize.value = value
        }

    private val _shoeDescription = MutableLiveData<String>()
    var shoeDescription: String
        get() = _shoeDescription.value ?: ""
        set(value) {
            _shoeDescription.value = value
        }

    init {
        Timber.i("_isSave Value : ${_isSave.value}")
    }

    fun onCancel() {
        _isCancel.value = true
    }

    fun onSave() {
        validateData()
    }

    private fun validateData() {
        _isSave.value =
            !(shoeName.isEmpty() || shoeCompany.isEmpty() || shoeSize.isEmpty() || shoeDescription.isEmpty())
    }
}
