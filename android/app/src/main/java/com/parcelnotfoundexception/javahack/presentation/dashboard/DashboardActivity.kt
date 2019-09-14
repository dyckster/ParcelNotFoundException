package com.parcelnotfoundexception.javahack.presentation.dashboard

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.presentation.BaseActivity
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.DashboardOptionsAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject
import javax.inject.Provider

class DashboardActivity : BaseActivity(), DashboardView {

    @Inject
    lateinit var provider: Provider<DashboardPresenter>

    @InjectPresenter
    lateinit var presenter: DashboardPresenter

    @ProvidePresenter
    fun providePresenter(): DashboardPresenter = provider.get()

    override fun viewCreated() {
        dashboardOptionsRecycler.adapter = DashboardOptionsAdapter {
            presenter.onMenuOptionClick(it)
        }
    }


    override fun onCardInfo(cardDisplayName: String, balance: String, pan: String) {
        cardName.text = cardDisplayName
        cardPan.text = pan
        cardBalance.text = balance
    }

    override fun openTimeline() {
    }


    override fun layoutRes() = R.layout.activity_dashboard

}