package com.example.viewmodelpost.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodelpost.R
import com.example.viewmodelpost.adapter.OnItemListener
import com.example.viewmodelpost.adapter.PostAdapter
import com.example.viewmodelpost.databinding.FragmentPostBinding
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_post.*

class PostFragment : Fragment(), OnItemListener {
    private lateinit var adapters: PostAdapter
    private lateinit var viewDataBinding: FragmentPostBinding

    private val postViewModel by viewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        viewModelPost = activity?.let { ViewModelProviders.of(it).get(PostViewModel::class.java) }!!
        viewDataBinding = FragmentPostBinding.inflate(inflater, container, false).apply {
            viewModel = postViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        setUpSwipeRefresh()
        postViewModel.fetchPostList().observe(viewLifecycleOwner, Observer {
            adapters.updatePostList(it)
        })

    }

    private fun setUpAdapter() {
        adapters = PostAdapter()
        adapters.setOnItemClick(this)
        rvPost.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = adapters
        }
    }

    @SuppressLint("ResourceAsColor")
    fun setUpSwipeRefresh() {
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary)
        swipeRefresh.setOnRefreshListener {
            Handler().postDelayed({
                postViewModel.fetchPostList().observe(viewLifecycleOwner, Observer {
                    adapters.updatePostList(it)
                    swipeRefresh.isRefreshing = false
                })
            }, 1000)
        }
    }

    override fun onClick(item: Post) {
        val bundle= bundleOf("detailPost" to item)
        this.findNavController().navigate(R.id.action_postFragment_to_detailPostFragment,bundle)
    }
}