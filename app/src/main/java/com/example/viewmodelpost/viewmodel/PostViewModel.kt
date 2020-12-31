package com.example.viewmodelpost.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.viewmodelpost.base.BaseViewModel
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.repository.PostsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postsRepository:  PostsRepository)   : BaseViewModel() {

    private val postListLiveData: MutableLiveData<DataState<List<Post>>> by lazy { MutableLiveData<DataState<List<Post>>>() }

     fun fetchPostList():LiveData<DataState<List<Post>>>{
     postsRepository.getPostList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                postListLiveData.value = DataState.Loading(true)
                disposable.add(it)
            }
            .subscribe({ posts ->
                postListLiveData.value = DataState.Loading(false)
                postListLiveData.value = DataState.Success(posts)
            }, {
                postListLiveData.value = DataState.Error(it)
            })
        return postListLiveData
    }

}