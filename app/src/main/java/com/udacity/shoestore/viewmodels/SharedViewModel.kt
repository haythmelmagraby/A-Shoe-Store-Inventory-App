package com.udacity.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {
    //    var shoeList:MutableLiveData<MutableList<String>>
    var shoeList = MutableLiveData<MutableList<Shoe>>()
    var shoeData = Shoe()

    private val _savedDetails = MutableLiveData<Boolean>()
    val savedDetails: LiveData<Boolean>
        get() = _savedDetails

    init {
        _savedDetails.value = false
            shoeList.value = mutableListOf()
    }

    fun addShoe() {
        shoeList.value?.add(shoeData)
        shoeList = shoeList
        _savedDetails.value = true
    }

    fun afterSavedDone() {
        _savedDetails.value = false
        // clearing edit text data
        shoeData=Shoe("","","","", mutableListOf(""))

    }
}
