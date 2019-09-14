package com.parcelnotfoundexception.javahack.data.repository

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import io.reactivex.Single

class AppTimelineRepository(private val api: JavaHackApi) : TimelineRepository {

    override fun getTimeline(): Single<List<TimelineEvent>> = api.getTimeline()

}