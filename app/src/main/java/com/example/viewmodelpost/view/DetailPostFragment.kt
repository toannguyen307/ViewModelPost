package com.example.viewmodelpost.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.viewmodelpost.R
import com.example.viewmodelpost.base.BaseFragment
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_detail_post.*

class DetailPostFragment : BaseFragment() {
//If your ViewModel is scoped to the navigation graph
//    val viewModel : PostViewModel by navGraphViewModels(R.id.nav_graph){
//        defaultViewModelProviderFactory
//    }


    var post: Post? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        post = arguments?.let { DetailPostFragmentArgs.fromBundle(it).detailPost }
    }

    override fun layoutId(): Int = R.layout.fragment_detail_post

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        post?.let {
            tvId.text = "ID: ${it.id}"
            tvBody.text = it.body
            tvTitle.text = it.title
            tvUserId.text = "User ID: ${it.userId}"
            tvNameAuthor.text = "Name Author: ${it.nameAuthor}"
        }
    }
}