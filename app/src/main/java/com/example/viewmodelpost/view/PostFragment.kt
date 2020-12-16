package com.example.viewmodelpost.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
    private lateinit var viewModelPost: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelPost= activity?.let { ViewModelProviders.of(it).get(PostViewModel::class.java)}!!
        viewDataBinding= FragmentPostBinding.inflate(inflater,container,false).apply {
           viewModel=viewModelPost
            lifecycleOwner = viewLifecycleOwner
        }

        return viewDataBinding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        swipeRefresh.setColorSchemeColors(R.color.black)
//        swipeRefresh.setOnRefreshListener {
//            Handler().postDelayed({
//                postPresenter.run {
//                    getData()
//                }
//            }, 1000)
//        }
        adapters = PostAdapter(this)
        rvPost?.also {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(context)
            it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            it.adapter = adapters
        }
        viewDataBinding.viewModel?.fetchPostList()?.observe(viewLifecycleOwner, Observer {
            adapters.updatePostList(it)
        })
    }

    override fun itemClick(post: Post) {
        viewModelPost.itemPost.value=post
        val detailPostFragment = DetailPostFragment()
        activity?.apply {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container,
                    detailPostFragment,
                    DetailPostFragment::class.java.simpleName
                )
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModelPost.destroyDisposable()
    }
}