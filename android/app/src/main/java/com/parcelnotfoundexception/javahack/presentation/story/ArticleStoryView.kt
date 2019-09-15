package com.parcelnotfoundexception.javahack.presentation.story

import com.arellomobile.mvp.MvpView

interface ArticleStoryView : MvpView {

    fun showTitle(title: String)

    fun showImage(image: String)

    fun showDescription(description: String)

}