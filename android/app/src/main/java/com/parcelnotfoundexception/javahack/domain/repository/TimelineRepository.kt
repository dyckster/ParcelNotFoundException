package com.parcelnotfoundexception.javahack.domain.repository

import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import io.reactivex.Single

interface TimelineRepository {

    fun getTimeline(): Single<List<TimelineEvent>>

}