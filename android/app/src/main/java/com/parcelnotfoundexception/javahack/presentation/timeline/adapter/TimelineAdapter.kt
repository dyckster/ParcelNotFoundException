package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.domain.model.TimelineEvent

class TimelineAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<TimelineListItem> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (ViewType.values()[viewType]) {
            ViewType.EVENT -> TimelineEventViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_timeline_event, parent, false
                )
            )
            ViewType.HEADER -> TimelineHeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_timeline_header, parent, false
                )
            )
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (item.viewType) {
            ViewType.EVENT -> {
                (holder as? TimelineEventViewHolder)?.bind(item.item as TimelineEvent)
            }
            ViewType.HEADER -> {
                val pair = item.item as Pair<*, *>
                (holder as? TimelineHeaderViewHolder)?.bind(
                    pair.first as String,
                    pair.second as String
                )
            }
        }
    }

}