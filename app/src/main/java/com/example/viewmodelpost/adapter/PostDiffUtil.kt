package com.example.viewmodelpost.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.viewmodelpost.model.Post

class PostDiffUtil(private val mOldPosts: List<Post>, private val mNewPosts: List<Post>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldPosts.size
    }

    override fun getNewListSize(): Int {
       return mNewPosts.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return mOldPosts[oldItemPosition].id==mNewPosts[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldPosts[oldItemPosition].title==mNewPosts[newItemPosition].title
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
