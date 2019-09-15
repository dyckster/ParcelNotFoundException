package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import com.parcelnotfoundexception.javahack.util.separateThousands
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

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
                val date = SimpleDateFormat("yyyy-MM-dd", Locale("ru")).parse(day)
                val dayFormatted = SimpleDateFormat("dd MMMM", Locale("ru")).format(date)
                val balance = entry.value.sumBy { it.amount.amount.toInt() }
                val balanceString = if (balance >= 0) {
                    "+ ${balance.separateThousands()} ₽"
                } else {
                    "– ${balance.separateThousands()} ₽"
                }
                val dayToBalance = dayFormatted to balanceString
                resultList.add(TimelineListItem(dayToBalance, ViewType.HEADER))
                resultList.addAll(entry.value.map { TimelineListItem(it, ViewType.EVENT) })
            }
        return resultList
    }

}