package com.parcelnotfoundexception.javahack.domain.model

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("accountId")
    val id: String,
    val cards: List<Card>,
    @SerializedName("requisites")
    val requisitesModel: RequisitesModel
)