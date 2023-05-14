package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = listOf(
            Shoe("Nike Air Max", "Nike", 9.5, "A classic sneaker"),
            Shoe("Adidas Superstar", "Adidas", 8.5, "A retro sneaker"),
            Shoe("Vans Old Skool", "Vans", 10.0, "A skateboarding shoe")

        )
    }

    fun addShoe(shoe: Shoe) {
        val currentList = _shoeList.value ?: emptyList()
        _shoeList.value = currentList + shoe
    }
}
