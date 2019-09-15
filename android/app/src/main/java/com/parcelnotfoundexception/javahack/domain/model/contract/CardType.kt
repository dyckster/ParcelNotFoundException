package com.parcelnotfoundexception.javahack.domain.model.contract

import com.google.gson.annotations.SerializedName

enum class CardType {
    @SerializedName("virtual")
    VIRTUAL,
    @SerializedName("plastic")
    PLASTIC
}