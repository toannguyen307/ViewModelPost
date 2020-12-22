package com.example.viewmodelpost.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.viewmodelpost.base.BaseViewModel
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class PostViewModel : BaseViewModel() {

    private val postListLiveData: MutableLiveData<List<Post>> by lazy { MutableLiveData<List<Post>>() }

    val itemPost: MutableLiveData<Post> by lazy { MutableLiveData<Post>() }

    fun fetchPostList(): LiveData<List<Post>> {
        showLoadingData.value = true
        PostRepository.getInstance().getPostList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                disposable.add(it)
            }
            .subscribe({ posts ->
                showLoadingData.value = false
                postListLiveData.value = posts
            }, {
                empty.value = true
            })
        return postListLiveData
    }
}