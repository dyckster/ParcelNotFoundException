package com.parcelnotfoundexception.javahack.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.domain.model.dashboard.Article
import com.parcelnotfoundexception.javahack.util.hide
import com.parcelnotfoundexception.javahack.util.show
import kotlinx.android.synthetic.main.item_dashboard_recommendation.view.*

class RecommendationsAdapter(private val listener: (Pair<String, ImageView>) -> Unit) :
    RecyclerView.Adapter<RecommendationViewHolder>() {

    var articles: List<Article> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        return RecommendationViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_dashboard_recommendation,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        val article = articles[position]
        if (article.isRead) {
            holder.itemView.alpha = 0.7f
        } else {
            holder.itemView.alpha = 1f
        }
        holder.bind(article)

        holder.itemView.setOnClickListener {
            listener.invoke(article.id to holder.itemView.articleImage)
        }
    }

}

class RecommendationViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(article: Article) {
        with(itemView) {
            if (article.articleType.isNullOrEmpty()) {
                articleType.hide()
            } else {
                articleType.text = article.articleType
                articleType.show()
            }
            articleName.text = article.articleTitle
            Glide.with(this)
                .load(article.articleImage)
                .into(articleImage)
        }
    }

}
