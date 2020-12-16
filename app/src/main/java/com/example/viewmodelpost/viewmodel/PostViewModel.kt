package com.example.viewmodelpost.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelpost.base.BaseViewModel
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.repository.PostRepository

class PostViewModel : BaseViewModel() {

    private val postListLiveData: MutableLiveData<List<Post>> by lazy { MutableLiveData<List<Post>>() }

    val itemPost : MutableLiveData<Post> by lazy { MutableLiveData<Post>() }

    fun destroyDisposable() {
        PostRepository.getInstance().disConnect()
    }

    fun fetchPostList(): LiveData<List<Post>> {
        showLoadingData.value = true
        PostRepository.getInstance().getPostList { isSuccess, postList ->
            showLoadingData.value = false
            if (isSuccess) {
                postListLiveData.value = postList
                empty.value = false
            } else {
                empty.value = true
            }
        }
        return postListLiveData
    }

}