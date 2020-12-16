package com.example.viewmodelpost.repository

import com.example.viewmodelpost.api.APIManager
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.model.Users
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class PostRepository {
    private val disposable: CompositeDisposable by lazy(::CompositeDisposable)
    companion object {
        private var INSTANCE: PostRepository? = null
        fun getInstance(): PostRepository {
            if (INSTANCE == null) {
                INSTANCE = PostRepository()
            }
            return INSTANCE!!
        }
    }

    fun getPostList(onResult: (isSuccess: Boolean, postList: List<Post>?) -> Unit) {
        disposable.add(
            Single.zip(getPostObservable(), getUsersObservable(),
                BiFunction { postsList, usersList ->
                    return@BiFunction filterNameAuthorPost(
                        postsList,
                        usersList
                    )
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    onResult(true, result)
                },
                    {
                        onResult(false, null)
                    }
                )
        )
    }

    private fun getUsersObservable(): Single<List<Users>> = APIManager.requestAPI.listUser()

    private fun getPostObservable(): Single<List<Post>> = APIManager.requestAPI.listPost()

    private fun filterNameAuthorPost(postsList: List<Post>, usersList: List<Users>): List<Post> {
        postsList.forEach { post ->
            post.nameAuthor = usersList.firstOrNull { it.id == post.userId }?.name.toString()
        }
        return postsList
    }

    fun disConnect() = disposable.clear()
}