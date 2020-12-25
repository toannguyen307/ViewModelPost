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

    private val postListLiveData: MutableLiveData<DataState<List<Post>>> by lazy { MutableLiveData<DataState<List<Post>>>()  }

    fun fetchPostList(): LiveData<DataState<List<Post>>> {
        PostRepository.getInstance().getPostList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                postListLiveData.value=DataState.Loading
                disposable.add(it)
            }
            .subscribe({ posts ->
                postListLiveData.value = DataState.Success(posts)
            }, {
                postListLiveData.value = DataState.Error(it)
            })
        return postListLiveData
    }
}