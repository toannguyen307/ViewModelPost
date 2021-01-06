package com.example.viewmodelpost.networking

import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.model.Users
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {
    @GET("/posts")
    fun listPost() : Single<List<Post>>
    @GET("/users")
    fun listUser(): Single<List<Users>>
}