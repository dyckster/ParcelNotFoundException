package com.parcelnotfoundexception.javahack.presentation.timeline

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.presentation.BaseActivity
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineAdapter
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineListItem
import kotlinx.android.synthetic.main.activity_timeline.*
import javax.inject.Inject
import javax.inject.Provider

class TimelineActivity : BaseActivity(), TimelineView {

    @Inject
    lateinit var provider: Provider<TimelinePresenter>

    @InjectPresenter
    lateinit var presenter: TimelinePresenter

    @ProvidePresenter
    fun providePresenter(): TimelinePresenter = provider.get()

    private val timelineAdapter = TimelineAdapter()

    override fun viewCreated() {
        timelineRecycler.adapter = timelineAdapter
    }

    override fun setItems(items: List<TimelineListItem>) {
        timelineAdapter.items = items
    }

    override fun layoutRes() = R.layout.activity_timeline

}