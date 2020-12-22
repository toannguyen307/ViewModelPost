package com.example.viewmodelpost.repository

import com.example.viewmodelpost.api.APIManager
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.model.Users
import io.reactivex.Single

class PostRepository {
    companion object {
        private var INSTANCE: PostRepository? = null
        fun getInstance(): PostRepository {
            if (INSTANCE == null) {
                INSTANCE = PostRepository()
            }
            return INSTANCE!!
        }
    }

    fun getPostList() : Single<List<Post>> {
        return Single.zip(getPostObservable(), getUsersObservable(), { posts, users ->
            filterNameAuthorPost(posts, users)
        })
    }

    private fun getUsersObservable(): Single<List<Users>> = APIManager.requestAPI.listUser()

    private fun getPostObservable(): Single<List<Post>> = APIManager.requestAPI.listPost()

    private fun filterNameAuthorPost(postsList: List<Post>, usersList: List<Users>): List<Post> {
        postsList.forEach { post ->
            post.nameAuthor = usersList.firstOrNull { it.id == post.userId }?.name.toString()
        }
        return postsList
    }
}