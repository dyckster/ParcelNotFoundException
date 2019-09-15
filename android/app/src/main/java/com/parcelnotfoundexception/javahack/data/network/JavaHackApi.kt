package com.parcelnotfoundexception.javahack.data.network

import com.parcelnotfoundexception.javahack.domain.model.Dashboard
import com.parcelnotfoundexception.javahack.domain.model.TimelineModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JavaHackApi {

    @GET("dashboard")
    fun getDashboard(): Single<Dashboard>

    @GET("operations/{cardId}")
    fun getTimeline(@Path("cardId") cardId: String): Single<TimelineModel>

}