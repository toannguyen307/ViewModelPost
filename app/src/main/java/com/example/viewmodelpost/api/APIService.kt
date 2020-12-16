package com.example.viewmodelpost.api

import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.model.Users
import io.reactivex.Single
import retrofit2.http.GET

interface APIService {
    companion object{
        const val URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("/posts")
    fun listPost() : Single<List<Post>>
    @GET("/users")
    fun listUser(): Single<List<Users>>
}