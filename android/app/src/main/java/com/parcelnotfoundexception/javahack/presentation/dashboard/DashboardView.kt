package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.MvpView
import com.parcelnotfoundexception.javahack.domain.model.Client

interface DashboardView : MvpView {

    fun showAnalyticsSection(month: String, expectedIncome: String, expectedTax: String)

    fun showCardInfo(cardName: String, cardTypeName: String, cardPan: String, cardBalance: String)

    fun showUserInfo(fullName: String, inn: String)

    fun showUserClients(clients: List<Client>)

    fun openRequisites()

    fun showRequisitesTab()

    fun showQrCodeTab()

    fun showRequisitesInfo(values: List<Pair<String, String>>)

    fun showQrCode(link: String)

    fun openTimeline()

}