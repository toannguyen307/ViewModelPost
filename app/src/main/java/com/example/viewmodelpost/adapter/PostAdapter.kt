package com.example.viewmodelpost.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodelpost.model.Post
import com.example.viewmodelpost.R
import com.example.viewmodelpost.viewmodel.PostViewModel

class PostAdapter(private val onItemListener: OnItemListener) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    var postList: List<Post> = emptyList()

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
        holder.tvTitle.text = "Title : ${postList[position].title}"
        holder.tvNameAuthor.text = "Name : ${postList[position].nameAuthor}"
        holder.line.setOnClickListener { onItemListener.itemClick(postList[position]) }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvNameAuthor: TextView = itemView.findViewById(R.id.tvNameAuthor)
        val line: LinearLayout = itemView.findViewById(R.id.line)
    }

}