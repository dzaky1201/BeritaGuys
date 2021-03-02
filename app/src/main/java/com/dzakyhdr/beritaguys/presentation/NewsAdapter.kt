package com.dzakyhdr.beritaguys.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dzakyhdr.beritaguys.R
import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.databinding.NewsListItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

     val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    inner class NewsViewHolder(
        private val binding: NewsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.txtTitle.text = article.title
            binding.txtDescription.text = article.description
            binding.txtSource.text = article.source.name
            binding.txtPublishAt.text = article.publishedAt
            binding.imgPoster.load(article.urlToImage) {
                crossfade(true)
                placeholder(R.drawable.ic_baseline_error_24)
            }
        }
    }
}