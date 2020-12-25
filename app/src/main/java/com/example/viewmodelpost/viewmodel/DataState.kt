package com.example.viewmodelpost.viewmodel

sealed class DataState<out T>{
    data class Loading(val state : Boolean) : DataState<Nothing>()
    data class Success<T>(val data: T) : DataState<T>()
    data class Error(val throwable: Throwable) : DataState<Nothing>()

}
