package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_timeline_header.view.*

class TimelineHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(date: String, balance: String) {
        with(itemView) {
            headerAmount.text = balance
            headerDate.text = date
        }
    }

}