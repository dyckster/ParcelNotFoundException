package com.parcelnotfoundexception.javahack.domain.model.dashboard

data class Article(
    val id: String,
    val articleTitle: String,
    val articleImage: String,
    val isRead: Boolean,
    val articleDescription: String? = null,
    val articleType: String? = null
)