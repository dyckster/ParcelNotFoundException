package com.parcelnotfoundexception.javahack.domain.model

import com.google.gson.annotations.SerializedName

data class TimelineEvent(
    val id: String,
    val displayName: String,
    val amount: Long,
    val taxAmount: Long?,
    val taxPercent: Int?,
    val subtitle: String?,
    val image: String,
    @SerializedName("operDate")
    val date: String
) {

    fun hasTaxInfo(): Boolean {
        return (taxAmount != null && taxPercent != null) && (taxPercent != 0 || taxAmount != 0L)
    }
}