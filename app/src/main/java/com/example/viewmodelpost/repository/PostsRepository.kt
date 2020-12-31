package com.example.viewmodelpost.repository

import com.example.viewmodelpost.model.Post
import io.reactivex.Single

interface PostsRepository {
    fun getPostList() : Single<List<Post>>
}