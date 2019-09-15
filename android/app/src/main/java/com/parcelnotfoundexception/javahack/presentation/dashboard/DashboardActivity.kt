package com.parcelnotfoundexception.javahack.presentation.dashboard

import androidx.cardview.widget.CardView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.domain.model.Client
import com.parcelnotfoundexception.javahack.presentation.BaseActivity
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.ClientsAdapter
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.OptionItem
import com.parcelnotfoundexception.javahack.presentation.dashboard.adapter.RequisitesAdapter
import com.parcelnotfoundexception.javahack.presentation.timeline.TimelineActivity
import com.parcelnotfoundexception.javahack.util.hide
import com.parcelnotfoundexception.javahack.util.show
import com.parcelnotfoundexception.javahack.util.toPx
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.fragment_requisites.*
import javax.inject.Inject
import javax.inject.Provider


class DashboardActivity : BaseActivity(), DashboardView {

    @Inject
    lateinit var provider: Provider<DashboardPresenter>

    @InjectPresenter
    lateinit var presenter: DashboardPresenter

    @ProvidePresenter
    fun providePresenter(): DashboardPresenter = provider.get()

    private val requisitesAdapter = RequisitesAdapter()
    private val clientAdapter = ClientsAdapter()

    private val sheetBehaviour: BottomSheetBehavior<CardView> by lazy {
        BottomSheetBehavior.from(
            bottomSheetRequisites
        )
    }

    override fun viewCreated() {
        sheetBehaviour.isHideable = true
        sheetBehaviour.skipCollapsed = true
        sheetBehaviour.state = BottomSheetBehavior.STATE_HIDDEN

        requisitesList.adapter = requisitesAdapter
        myClientsList.adapter = clientAdapter
        requisitesButton.setOnClickListener { presenter.showRequisitesTab() }
        qrButtonGroup.setOnClickListener { presenter.showQrTab() }
        requisitesButtonCard.setOnClickListener { presenter.onMenuOptionClick(OptionItem.REQUISITES) }
        analyticsButton.setOnClickListener { presenter.onMenuOptionClick(OptionItem.HISTORY) }
        qrButton.setOnClickListener { presenter.onMenuOptionClick(OptionItem.QR_CODE) }
        analyticGroup.setOnClickListener { presenter.onMenuOptionClick(OptionItem.HISTORY) }
    }

    override fun showAnalyticsSection(month: String, expectedIncome: String, expectedTax: String) {
        analyticsMonth.text = month
        expectedIncomeAmount.text = expectedIncome
        expectedTaxAmount.text = expectedTax
    }

    override fun showUserClients(clients: List<Client>) {
        clientAdapter.clients = clients
    }

    override fun showCardInfo(
        cardName: String,
        cardTypeName: String,
        cardPan: String,
        cardBalance: String
    ) {
        cardNameText.text = cardName
        cardType.text = cardTypeName
        cardBalanceText.text = cardBalance
        cardPanText.text = cardPan
    }

    override fun showUserInfo(fullName: String, inn: String) {
        clientName.text = fullName
        clientInn.text = inn
    }

    override fun openTimeline(cardId: String) {
        TimelineActivity.start(this, cardId)
    }

    override fun openRequisites() {
        sheetBehaviour.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onBackPressed() {
        if (sheetBehaviour.state != BottomSheetBehavior.STATE_HIDDEN) {
            sheetBehaviour.state = BottomSheetBehavior.STATE_HIDDEN
        } else {
            super.onBackPressed()
        }
    }

    override fun showRequisitesTab() {
        requisitesButton.animate().setDuration(150L).alpha(1.0f)
        requisitesButton.setBackgroundResource(R.drawable.shape_rounded_light_64dp)

        qrButtonGroup.background = null
        qrButtonIcon.animate().setDuration(150L).alpha(0.4f)
        qrButtonText.animate().setDuration(150L).alpha(0.4f)
    }

    override fun showQrCodeTab() {
        requisitesButton.animate().setDuration(150L).alpha(0.4f)
        requisitesButton.background = null

        qrButtonGroup.setBackgroundResource(R.drawable.shape_rounded_light_64dp)
        qrButtonIcon.animate().setDuration(150L).alpha(1.0f)
        qrButtonText.animate().setDuration(150L).alpha(1.0f)
    }

    override fun showRequisitesInfo(values: List<Pair<String, String>>) {
        requisitesList.show()
        qrGroup.hide()
        requisitesAdapter.items = values
    }

    override fun showQrCode(link: String) {
        qrGroup.show()
        requisitesList.hide()

        val barcodeEncoder = BarcodeEncoder()
        val bitmap =
            barcodeEncoder.encodeBitmap(
                link, BarcodeFormat.QR_CODE,
                400.toPx(this),
                400.toPx(this)
            )

        qrImage.setImageBitmap(bitmap)
    }

    override fun layoutRes() = R.layout.activity_dashboard

}