package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.InjectViewState
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
                viewState.onCardInfo("Карта для самозанятых", "30 000", "**9999")
            }, {

            })
            .also { disposable.add(it) }
    }

    fun onMenuOptionClick(optionItem: OptionItem) {

    }
}