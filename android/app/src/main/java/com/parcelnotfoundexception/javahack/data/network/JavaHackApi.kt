package com.parcelnotfoundexception.javahack.data.network

import com.parcelnotfoundexception.javahack.domain.model.Dashboard
import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import io.reactivex.Single
import retrofit2.http.GET

interface JavaHackApi {

    @GET("dashboard")
    fun getDashboard(): Single<Dashboard>

    @GET("timeline")
    fun getTimeline(): Single<List<TimelineEvent>>

}