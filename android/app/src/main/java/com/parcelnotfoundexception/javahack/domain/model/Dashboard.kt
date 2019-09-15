package com.parcelnotfoundexception.javahack.domain.model

data class Dashboard(
    val user: UserInfo,
    val accounts: List<Account>,
    val timelineSummary: TimelineSummary
)