package com.parcelnotfoundexception.javahack.domain.model

data class TimelineEvent(
    val id: String,
    val amount: TimelineAmount,
    val displayName: String,
    val subtitle: String?,
    val image: String,
    val date: String
)