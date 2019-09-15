package com.parcelnotfoundexception.javahack.presentation.timeline

import android.content.Context
import android.content.Intent
import android.view.MenuItem
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
        setSupportActionBar(toolbar)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.fetchTimeline(intent.getStringExtra(EXTRA_CARD_ID))
        timelineRecycler.adapter = timelineAdapter

        monthsList.adapter = monthsAdapter
        monthsList.setOffscreenItems(12)
        monthsList.addOnItemChangedListener { viewHolder, position ->
            val selectedMonth = (viewHolder?.itemView as? TextView)?.text.toString()
            presenter.onMonthSelected(selectedMonth)
        }
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

    override fun prepareMonths(months: List<String>) {
        monthsAdapter.months = months
        monthsList.scrollToPosition(months.size)
    }


    override fun setItems(items: List<TimelineListItem>) {
        timelineAdapter.items = items
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun layoutRes() = R.layout.activity_timeline

    companion object {

        private const val EXTRA_CARD_ID = "card_id"

        fun start(context: Context, cardId: String) {
            val intent = Intent(context, TimelineActivity::class.java)
            intent.putExtra(EXTRA_CARD_ID, cardId)
            context.startActivity(intent)
        }

    }

}

