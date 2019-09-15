package com.parcelnotfoundexception.javahack.data.repository

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.domain.model.TimelineModel
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import io.reactivex.Single

class AppTimelineRepository(private val api: JavaHackApi) : TimelineRepository {

    private var cache: TimelineModel? = null

    override fun getTimeline(cardId: String): Single<TimelineModel> = if (cache != null) {
        Single.just(cache)
    } else api.getTimeline(cardId).doOnSuccess { cache = it }

}