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
            Glide.with(this)
                .load(event.image)
                .into(eventIcon)
            eventSum.text = event.amount.amount.toInt().separateThousands()
            eventTitle.text = event.displayName
            eventSubtitle?.apply {
                if (event.subtitle.isNullOrBlank()) {
                    hide()
                } else {
                    show()
                }
                text = event.subtitle
            }

            if (event.amount.hasTaxInfo()) {
                taxAmount.show()
                taxPercent.show()

                taxAmount.text = event.amount.taxAmount?.toInt()?.separateThousands() ?: ""
                taxPercent.text = event.amount.taxPercent.toString()
            } else {
                taxAmount.hide()
                taxPercent.hide()
            }
        }
    }

}