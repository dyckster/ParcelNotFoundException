package com.parcelnotfoundexception.javahack.presentation.story

import com.arellomobile.mvp.InjectViewState
import com.parcelnotfoundexception.javahack.domain.repository.ArticleRepository
import com.parcelnotfoundexception.javahack.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class ArticleStoryPresenter @Inject constructor() : BasePresenter<ArticleStoryView>() {

    @Inject
    lateinit var articleRepository: ArticleRepository

    fun fetchArticle(articleId: String) {
        articleRepository.getArticleById(articleId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showDescription(it.articleDescription ?: "")
                viewState.showTitle(it.articleTitle)
                viewState.showImage(it.articleImage)
            }, {

            })
            .also { disposable.add(it) }
        articleRepository.setAsViewed(articleId).subscribe({}, {})
            .also { disposable.add(it) }
    }

}