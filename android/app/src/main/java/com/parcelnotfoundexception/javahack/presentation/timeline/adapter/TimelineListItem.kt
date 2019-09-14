package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import com.parcelnotfoundexception.javahack.util.separateThousands

data class TimelineListItem(
    val item: Any?,
    val viewType: ViewType
)

class TimelineListMapper {

    fun map(items: List<TimelineEvent>): List<TimelineListItem> {
        val resultList: MutableList<TimelineListItem> = ArrayList()
        items.groupBy { it.date }.toSortedMap()
            .forEach { entry ->
                val day = entry.key
                val balance = entry.value.sumBy { it.amount.amount.toInt() }.separateThousands()
                val dayToBalance = day to balance
                resultList.add(TimelineListItem(dayToBalance, ViewType.HEADER))
                resultList.addAll(entry.value.map { TimelineListItem(it, ViewType.EVENT) })
            }
        return resultList
    }

}