package com.parcelnotfoundexception.javahack.domain.model

import com.google.gson.annotations.SerializedName

data class YearlySum(
    @SerializedName("JANUARY")
    val january: Long?,
    @SerializedName("FEBRUARY")
    val february: Long?,
    @SerializedName("MARCH")
    val march: Long?,
    @SerializedName("APRIL")
    val april: Long?,
    @SerializedName("MAY")
    val may: Long?,
    @SerializedName("JUNE")
    val june: Long?,
    @SerializedName("JULY")
    val july: Long?,
    @SerializedName("AUGUST")
    val august: Long?,
    @SerializedName("SEPTEMBER")
    val september: Long?,
    @SerializedName("OCTOBER")
    val october: Long?,
    @SerializedName("NOVEMBER")
    val november: Long?,
    @SerializedName("DECEMBER")
    val december: Long?
) {

    fun getProperlyFormattedMonths(): List<Pair<String, Long>> {
        return listOf(
            "Январь" to january,
            "Февраль" to february,
            "Март" to march,
            "Апрель" to april,
            "Май" to may,
            "Июнь" to june,
            "Июль" to july,
            "Август" to august,
            "Сентябрь" to september,
            "Октябрь" to october,
            "Ноябрь" to november,
            "Декабрь" to december
        ).filter { it.second != null }
            .map { it.first to it.second!! }
    }

    fun getSumForMonth(month: String): Long {
        return getProperlyFormattedMonths().find { it.first == month }?.second ?: 0L
    }

}