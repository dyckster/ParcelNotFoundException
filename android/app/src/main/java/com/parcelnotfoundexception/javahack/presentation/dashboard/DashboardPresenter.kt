package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.InjectViewState
import com.parcelnotfoundexception.javahack.domain.model.*
import com.parcelnotfoundexception.javahack.domain.repository.DashboardRepository
import com.parcelnotfoundexception.javahack.presentation.BasePresenter
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.OptionItem
import com.parcelnotfoundexception.javahack.util.separateThousands
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@InjectViewState
class DashboardPresenter @Inject constructor(

) : BasePresenter<DashboardView>() {

    @Inject
    lateinit var dashboardRepository: DashboardRepository

    private var user: UserInfo? = null
    private var account: Account? = null
    private var card: Card? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        dashboardRepository.getDashboard()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                viewState.showUserInfo(it.user.fullName, it.user.userInn)

                user = it.user
                account = it.accounts.first()
                card = account?.cards?.find { card -> card.cardType == CardType.VIRTUAL }?.apply {
                    viewState.showCardInfo(
                        displayName,
                        if (cardType == CardType.VIRTUAL) "Виртуальная" else "Пластиковая",
                        panTail,
                        (balance / 100).separateThousands()
                    )
                }
                viewState.showAnalyticsSection(
                    "Сентябрь",
                    "${(it.timelineSummary.currentMonthCredit / 100).separateThousands()} ₽",
                    "${(it.timelineSummary.currentMonthTax / 100).separateThousands()} ₽"
                )
            }, {

            })
            .also { disposable.add(it) }

        viewState.showUserClients(
            listOf(
                Client("1", "Наталья Сергеевна", "", "https://i.imgur.com/LokWmT8.png"),
                Client("2", "Андрей Мальковский", "", "https://i.imgur.com/I5vN2hA.png"),
                Client("3", "Кристина Кравцова", "", "https://i.imgur.com/zrRubpk.png"),
                Client("3", "Юрий Домбаев", "", "https://i.imgur.com/DMAckN3.png"),
                Client("3", "Виталий Сокирко", "", "https://i.imgur.com/4FnBiBJ.png"),
                Client("4", "Анастасия Дмитриева", "", "https://i.imgur.com/t21Eh54.png"),
                Client("6", "Николай Крючков", "", "https://i.imgur.com/iofoyOo.png")
            )
        )
    }

    fun onMenuOptionClick(optionItem: OptionItem) {
        when (optionItem) {
            OptionItem.HISTORY -> {
                viewState.openTimeline(card!!.id)
            }
            OptionItem.REQUISITES -> {
                viewState.openRequisites()
                showRequisitesTab()
            }
            OptionItem.QR_CODE -> {
                viewState.openRequisites()
                showQrTab()
            }
        }
    }

    fun showRequisitesTab() {
        viewState.showRequisitesTab()
        viewState.showRequisitesInfo(
            listOf(
                "Получатель" to (user?.fullName ?: "Нет данных"),
                "БИК банка" to (account?.requisitesModel?.bankBik ?: "Нет данных"),
                "ИНН" to (account?.requisitesModel?.inn ?: "Нет данных"),
                "Корр. Счет" to (account?.requisitesModel?.ogrnip ?: "Нет данных"),
                "Бик получателя" to (account?.requisitesModel?.clientBik ?: "Нет данных"),
                "Банк" to "Райффайзенбанк",
                "Номер счета" to (account?.requisitesModel?.accountNumber ?: "Нет данных")
            )
        )
    }

    fun showQrTab() {
        viewState.showQrCodeTab()
        card?.apply {
            viewState.showQrCode(replenishUrl)
        }
    }

}