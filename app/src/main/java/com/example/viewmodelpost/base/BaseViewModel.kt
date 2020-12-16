package com.example.viewmodelpost.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val empty = MutableLiveData<Boolean>().apply { value = false }
    val showLoadingData = MutableLiveData<Boolean>().apply { value = false }
}