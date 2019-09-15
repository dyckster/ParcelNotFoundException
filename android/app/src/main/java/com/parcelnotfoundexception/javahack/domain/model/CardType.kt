package com.parcelnotfoundexception.javahack.domain.model

import com.google.gson.annotations.SerializedName

enum class CardType {
    @SerializedName("virtual")
    VIRTUAL,
    @SerializedName("plastic")
    PLASTIC
}