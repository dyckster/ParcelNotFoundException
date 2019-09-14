package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.MvpView

interface DashboardView : MvpView {

    fun onCardInfo(
        cardDisplayName: String,
        balance: String,
        pan: String
    )


    fun openTimeline()
}