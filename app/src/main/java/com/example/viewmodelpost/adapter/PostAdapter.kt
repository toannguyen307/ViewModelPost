package com.example.viewmodelpost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.R
import kotlinx.android.synthetic.main.post_item_view.view.*

class PostAdapter :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    var postList: List<Post> = emptyList()

    lateinit var onItemListener: OnItemListener

    fun setOnItemClick(onItemListener: OnItemListener) {
        this.onItemListener = onItemListener
    }

    fun updatePostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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