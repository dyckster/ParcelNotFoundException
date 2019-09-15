package com.parcelnotfoundexception.javahack.domain.repository

import com.parcelnotfoundexception.javahack.domain.model.dashboard.Article
import io.reactivex.Single

interface ArticleRepository {

    fun getArticles(): Single<List<Article>>

    fun getArticleById(id: String): Single<Article>

    fun setAsViewed(storyId: String): Single<Void>

}