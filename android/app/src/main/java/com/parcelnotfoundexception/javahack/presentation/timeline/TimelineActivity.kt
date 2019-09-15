package com.parcelnotfoundexception.javahack.presentation.timeline

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.presentation.BaseActivity
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineAdapter
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineListItem
import com.parcelnotfoundexception.javahack.presentation.timeline.adapter.TimelineMonthAdapter
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
    private val monthsAdapter = TimelineMonthAdapter()

    override fun viewCreated() {
        timelineRecycler.adapter = timelineAdapter

        monthsList.adapter = monthsAdapter
        monthsList.setOffscreenItems(12)
        monthsList.addOnItemChangedListener { viewHolder, position ->
            val selectedMonth = (viewHolder?.itemView as? TextView)?.text.toString()
            presenter.onMonthSelected(selectedMonth)
        }
        val mList = listOf("Июнь", "Июль", "Август", "Сентябрь")
        monthsAdapter.months = mList
        monthsList.scrollToPosition(mList.size)
    }

    override fun onMonthDataSelected(
        incomeBase: String,
        income: String,
        expense: String,
        tax: String
    ) {
        monthlySum.text = incomeBase
        blockExpense.text = expense
        blockIncome.text = income
        blockTax.text = tax
    }

    override fun setItems(items: List<TimelineListItem>) {
        timelineAdapter.items = items
    }

    override fun layoutRes() = R.layout.activity_timeline

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, TimelineActivity::class.java)
            context.startActivity(intent)
        }

    }

}

