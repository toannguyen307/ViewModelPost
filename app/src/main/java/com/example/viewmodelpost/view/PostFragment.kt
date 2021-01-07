package com.example.viewmodelpost.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelpost.R
import com.example.viewmodelpost.adapter.OnItemListener
import com.example.viewmodelpost.adapter.PostAdapter
import com.example.viewmodelpost.base.BaseFragment
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.viewmodel.DataState
import com.example.viewmodelpost.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_post.*
import javax.inject.Inject

@AndroidEntryPoint
class PostFragment : BaseFragment(), OnItemListener {
    @Inject
    lateinit var adapters: PostAdapter
    private val postViewModel: PostViewModel by viewModels()

    //    @Inject
//    lateinit var postViewModel: PostViewModel
    override fun layoutId(): Int = R.layout.fragment_post
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setUpSwipeRefresh()
        showData()
    }

    private fun showData() {
        postViewModel.fetchPostList().observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Loading -> {
                    if (it.states) {
                        progressBar.visibility = View.VISIBLE
                    } else {
                        swipeRefresh.isRefreshing = false
                        progressBar.visibility = View.GONE
                    }
                }
                is DataState.Success -> {
                   adapters.submitList(it.data)
                }
                is DataState.Error -> {
                    txtError.text = "Disconnect NetWork"
                    Log.e("TAG", "Disconnect NetWork")
                }
            }
        })
    }

    private fun setUpAdapter() {
        adapters.setOnItemClick(this)
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(activity)
        rvPost.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        rvPost.adapter = adapters
    }

    @SuppressLint("ResourceAsColor")
    fun setUpSwipeRefresh() {
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary)
        swipeRefresh.setOnRefreshListener {
            Handler().postDelayed({
                showData()
            }, 1000)
        }
    }

    override fun onClick(item: Post) {
        val bundle = bundleOf("detailPost" to item)
        this.findNavController().navigate(R.id.action_postFragment_to_detailPostFragment, bundle)
    }
}