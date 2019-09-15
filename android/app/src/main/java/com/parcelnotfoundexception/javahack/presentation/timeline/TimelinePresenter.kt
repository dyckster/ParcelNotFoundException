package com.parcelnotfoundexception.javahack.presentation.timeline

import com.arellomobile.mvp.InjectViewState
import com.parcelnotfoundexception.javahack.domain.repository.TimelineRepository
import com.parcelnotfoundexception.javahack.presentation.BasePresenter
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineListMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class TimelinePresenter @Inject constructor() : BasePresenter<TimelineView>() {

    @Inject
    lateinit var timelineRepository: TimelineRepository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        timelineRepository.getTimeline()
            .flatMap {
                Single.fromCallable {
                    TimelineListMapper().map(it)
                }.subscribeOn(Schedulers.computation())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setItems(it)
            }, {

            })
            .also { disposable.add(it) }
    }

    fun onMonthSelected(selectedMonth: String) {
        if (selectedMonth.isBlank()) return
        viewState.onMonthDataSelected("30 000 ₽", "+ 50 000 ₽", "- 20 000 ₽", "– 3 000 ₽")

    }

}