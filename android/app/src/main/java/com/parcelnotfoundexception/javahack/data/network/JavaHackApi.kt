package com.parcelnotfoundexception.javahack.data.network

import com.parcelnotfoundexception.javahack.domain.model.dashboard.Article
import com.parcelnotfoundexception.javahack.domain.model.dashboard.Dashboard
import com.parcelnotfoundexception.javahack.domain.model.timeline.TimelineModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface JavaHackApi {

    @GET("dashboard")
    fun getDashboard(): Single<Dashboard>

    @GET("operations/{cardId}")
    fun getTimeline(@Path("cardId") cardId: String): Single<TimelineModel>

    @GET("stories")
    fun getArticles(): Single<List<Article>>

    @PUT("stories/view/{storyId}")
    fun setArticleAsRead(@Path("storyId") storyId: String): Single<Void>

}