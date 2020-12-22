package com.example.viewmodelpost.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodelpost.R
import com.example.viewmodelpost.databinding.FragmentDetailPostBinding
import com.example.viewmodelpost.databinding.FragmentPostBinding
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.fragment_detail_post.*

class DetailPostFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentDetailPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentDetailPostBinding.inflate(inflater, container, false).apply {
            viewModel = activity?.let { ViewModelProviders.of(it).get(PostViewModel::class.java) }
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}