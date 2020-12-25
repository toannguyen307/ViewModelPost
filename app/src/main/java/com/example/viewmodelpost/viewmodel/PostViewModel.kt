package com.example.viewmodelpost.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelpost.base.BaseViewModel
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class PostViewModel : BaseViewModel() {

    private val postListLiveData: MutableLiveData<List<Post>> by lazy { MutableLiveData<List<Post>>()  }

    fun fetchPostList(): LiveData<List<Post>> {
        PostRepository.getInstance().getPostList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                showLoadingData.value = true
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


    class PostViewModelFactory() : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PostViewModel() as T
        }

    }
}