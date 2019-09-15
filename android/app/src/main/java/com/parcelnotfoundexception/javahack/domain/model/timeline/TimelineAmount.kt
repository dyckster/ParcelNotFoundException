package com.parcelnotfoundexception.javahack.domain.model.timeline

data class TimelineAmount(
    val amount: Long,
    val taxAmount: Long?,
    val taxPercent: Double?
) {

    fun hasTaxInfo(): Boolean {
        return taxAmount != null && taxPercent != null
    }

}