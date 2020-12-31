package com.example.viewmodelpost.di

import com.example.viewmodelpost.api.PostApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostService @Inject constructor(retrofit: Retrofit) : PostApi {
    private val postApi by lazy { retrofit.create(PostApi::class.java) }
    override fun listPost() = postApi.listPost()
    override fun listUser() = postApi.listUser()
}