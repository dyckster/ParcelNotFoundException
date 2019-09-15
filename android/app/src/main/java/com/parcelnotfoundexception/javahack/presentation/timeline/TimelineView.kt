package com.parcelnotfoundexception.javahack.presentation.timeline

import com.arellomobile.mvp.MvpView
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineListItem

interface TimelineView : MvpView {

    fun setItems(items: List<TimelineListItem>)

    fun onMonthDataSelected(incomeBase: String, income: String, expense: String, tax: String)

}