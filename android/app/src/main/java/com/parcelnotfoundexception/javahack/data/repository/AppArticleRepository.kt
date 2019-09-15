package com.parcelnotfoundexception.javahack.data.repository

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.domain.model.dashboard.Article
import com.parcelnotfoundexception.javahack.domain.repository.ArticleRepository
import io.reactivex.Single

class AppArticleRepository(private val api: JavaHackApi) : ArticleRepository {

    private var article: MutableMap<String, Article> = HashMap()

    override fun getArticles(): Single<List<Article>> {
        return api.getArticles().map {
            it.onEach { a -> article[a.id] = a }
            return@map it.sortedBy { it.isRead }
        }
    }

    override fun setAsViewed(storyId: String): Single<Void> = api.setArticleAsRead(storyId)

    override fun getArticleById(id: String): Single<Article> = Single.just(article[id])
}