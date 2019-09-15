package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent
import com.parcelnotfoundexception.javahack.util.hide
import com.parcelnotfoundexception.javahack.util.separateThousands
import com.parcelnotfoundexception.javahack.util.show
import kotlinx.android.synthetic.main.item_timeline_event.view.*

class TimelineEventViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(event: TimelineEvent) {
        with(itemView) {

            val image = if (!event.image.contains(".png") &&
                !event.image.contains(".jpg")
            ) {
                "${event.image}.png"
            } else {
                event.image
            }
            Glide.with(this)
                .load(image)
                .into(eventIcon)
            val amount = event.amount
            val amountString = if (amount >= 0) {
                "+ ${amount.separateThousands()} ₽"
            } else {
                "– ${amount.separateThousands(true)} ₽"
            }
            eventSum.text = amountString
            eventTitle.text = event.displayName
            eventSubtitle?.apply {
                if (event.subtitle.isNullOrBlank()) {
                    hide()
                } else {
                    show()
                }
                text = event.subtitle
            }

            if (event.hasTaxInfo()) {
                taxAmount.show()
                taxPercent.show()

                taxAmount.text = "${event.taxAmount?.separateThousands()} ₽"
                taxPercent.text = "${event.taxPercent.toString()} %"
            } else {
                taxAmount.hide()
                taxPercent.hide()
            }
        }
    }

}