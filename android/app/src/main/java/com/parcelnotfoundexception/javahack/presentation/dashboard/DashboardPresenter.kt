package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.InjectViewState
import com.parcelnotfoundexception.javahack.domain.model.Client
import com.parcelnotfoundexception.javahack.domain.repository.DashboardRepository
import com.parcelnotfoundexception.javahack.presentation.BasePresenter
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.OptionItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class DashboardPresenter @Inject constructor(

) : BasePresenter<DashboardView>() {

    @Inject
    lateinit var dashboardRepository: DashboardRepository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        dashboardRepository.getDashboard()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {

            })
            .also { disposable.add(it) }
        viewState.showAnalyticsSection("Сентябрь", "30 000 ₽", "2 700 ₽")
        viewState.showUserInfo("Кристина Кравцова", "122122121")
        viewState.showCardInfo("Карта для бизнеса", "Виртуальная", "*8888", "30 000")

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
                viewState.openTimeline()
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
                "Получатель" to "Кристина Кравцова",
                "БИК" to "0404040",
                "ИНН" to "1111111",
                "КПП" to "1111",
                "Корр. Счет" to "12123123",
                "Банк" to "Райф",
                "Номер счета" to "121121111 11111"
            )
        )
    }

    fun showQrTab() {
        viewState.showQrCodeTab()
        viewState.showQrCode("https://www.figma.com/proto/7ZLB0XIlXle7GxFKArrlEm/Java-hack?node-id=17%3A228&viewport=-2429%2C-494%2C0.6746377348899841&scaling=scale-down")
    }

}