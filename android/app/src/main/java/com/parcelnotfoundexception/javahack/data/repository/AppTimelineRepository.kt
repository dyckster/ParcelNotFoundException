package com.parcelnotfoundexception.javahack.data.repository

import com.parcelnotfoundexception.javahack.data.network.JavaHackApi
import com.parcelnotfoundexception.javahack.domain.model.TimelineAmount
import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import io.reactivex.Single

class AppTimelineRepository(private val api: JavaHackApi) : TimelineRepository {

//    override fun getTimeline(): Single<List<TimelineEvent>> = api.getTimeline()

    override fun getTimeline(): Single<List<TimelineEvent>> {
        return Single.just(
            listOf(
                TimelineEvent(
                    id = "1",
                    amount = TimelineAmount(100, null, null),
                    displayName = "Перевод средств",
                    subtitle = "*8888",
                    image = "https://i.imgur.com/wxfJTaT.jpg",
                    date = "2019-10-05"
                ),
                TimelineEvent(
                    id = "2",
                    amount = TimelineAmount(10000, 100, 4.0),
                    displayName = "Перевод средств",
                    subtitle = "*8888",
                    image = "https://i.imgur.com/wxfJTaT.jpg",
                    date = "2019-10-05"
                ),
                TimelineEvent(
                    id = "3",
                    amount = TimelineAmount(100000, null, null),
                    displayName = "Перевод средств",
                    subtitle = "*8888",
                    image = "https://i.imgur.com/QgobW8A.jpg",
                    date = "2019-10-04"
                ),
                TimelineEvent(
                    id = "4",
                    amount = TimelineAmount(10012, null, null),
                    displayName = "Перевод средств",
                    subtitle = "",
                    image = "https://i.imgur.com/QgobW8A.jpg",
                    date = "2019-10-04"
                ),
                TimelineEvent(
                    id = "5",
                    amount = TimelineAmount(10011, null, null),
                    displayName = "Перевод средств",
                    subtitle = "",
                    image = "https://i.imgur.com/QgobW8A.jpg",
                    date = "2019-10-04"
                )
            )
        )
    }

}