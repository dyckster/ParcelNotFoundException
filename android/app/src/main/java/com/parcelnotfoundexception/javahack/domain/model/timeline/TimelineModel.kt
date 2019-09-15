package com.parcelnotfoundexception.javahack.domain.model.timeline

import com.google.gson.annotations.SerializedName

data class TimelineModel(
    @SerializedName("totalAmounts")
    val totalAmount: TotalAmount,
    @SerializedName("operations")
    val events: List<TimelineEvent>
)