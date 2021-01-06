package com.example.viewmodelpost.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val disposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}