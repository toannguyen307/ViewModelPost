package com.example.viewmodelpost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelpost.R
import com.example.viewmodelpost.model.Post
import kotlinx.android.synthetic.main.post_item_view.view.*
import javax.inject.Inject

class PostAdapter @Inject constructor() : RecyclerView.Adapter<PostAdapter.ViewHolder>(
) {
   private val postList: MutableList<Post> = mutableListOf()

    lateinit var onItemListener: OnItemListener

    fun setOnItemClick(onItemListener: OnItemListener) {
        this.onItemListener = onItemListener
    }

    fun submitList(posts: List<Post>) {
        val diffResult = DiffUtil.calculateDiff(PostDiffUtil(postList, posts))
        postList.clear()
        postList.addAll(posts)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.setUp(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setUp(post: Post) {
            itemView.tvTitle.text = post.title
            itemView.tvNameAuthor.text = post.nameAuthor
            itemView.setOnClickListener {
                onItemListener.onClick(post)
            }
        }
    }

}