package com.parcelnotfoundexception.javahack.domain.model

import com.google.gson.annotations.SerializedName

data class Card(
    val id: String,
    val displayName: String,
    @SerializedName("availableLimitAmount")
    val balance: Long,
    val cardType: CardType,
    val panTail: String,
    val replenishUrl: String,
    @SerializedName("expDate")
    val expireDate: String
)