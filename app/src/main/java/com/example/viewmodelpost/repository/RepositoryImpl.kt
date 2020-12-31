package com.example.viewmodelpost.repository

import com.example.viewmodelpost.di.PostService
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.model.Users
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val service: PostService) : PostsRepository {
    override fun getPostList(): Single<List<Post>> {
        return Single.zip(service.listPost(), service.listUser(), { posts, users ->
            filterNameAuthorPost(posts, users)
        })
    }

    private fun filterNameAuthorPost(postsList: List<Post>, usersList: List<Users>): List<Post> {
        postsList.map { post->
            post.nameAuthor= usersList.firstOrNull { it.id == post.userId }?.name.toString()
        }
        return postsList
    }
}