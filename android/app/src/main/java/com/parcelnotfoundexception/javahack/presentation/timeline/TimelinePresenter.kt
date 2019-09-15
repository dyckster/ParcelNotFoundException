package com.parcelnotfoundexception.javahack.presentation.timeline

import com.arellomobile.mvp.InjectViewState
import com.parcelnotfoundexception.javahack.domain.model.timeline.TotalAmount
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import com.parcelnotfoundexception.javahack.presentation.BasePresenter
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineListMapper
import com.parcelnotfoundexception.javahack.util.separateThousands
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class TimelinePresenter @Inject constructor() : BasePresenter<TimelineView>() {

    @Inject
    lateinit var timelineRepository: TimelineRepository

    private var totalAmount: TotalAmount? = null

    fun fetchTimeline(cardId: String) {
        timelineRepository.getTimeline(cardId)
            .flatMap {
                totalAmount = it.totalAmount
                Single.fromCallable {
                    TimelineListMapper().map(it.events)
                }.subscribeOn(Schedulers.computation())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.prepareMonths(totalAmount?.getMaxAvailableMonths() ?: emptyList())
                viewState.setItems(it)
            }, {

            })
            .also { disposable.add(it) }
    }

    fun onMonthSelected(selectedMonth: String) {
        if (selectedMonth.isBlank()) return

        totalAmount?.apply {
            val income = getMonthlyCredit().getSumForMonth(selectedMonth) / 100
            val expense = getMonthlyDebit().getSumForMonth(selectedMonth) / 100
            val tax = getMonthlyTax().getSumForMonth(selectedMonth) / 100

            val baseIncome = income + expense - tax

            viewState.onMonthDataSelected(
                "${baseIncome.separateThousands()} ₽",
                "${income.separateThousands()} ₽",
                "${expense.separateThousands()} ₽",
                "${tax.separateThousands()} ₽"
            )

        }

    }

}