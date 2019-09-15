package com.parcelnotfoundexception.javahack.domain.repository

import com.parcelnotfoundexception.javahack.domain.model.TimelineModel
import io.reactivex.Single

interface TimelineRepository {

    fun getTimeline(cardId: String): Single<TimelineModel>

}