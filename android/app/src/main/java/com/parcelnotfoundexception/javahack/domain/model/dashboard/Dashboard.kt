package com.parcelnotfoundexception.javahack.domain.model.dashboard

import com.parcelnotfoundexception.javahack.domain.model.contract.Account

data class Dashboard(
    val user: UserInfo,
    val accounts: List<Account>,
    val timelineSummary: TimelineSummary
)