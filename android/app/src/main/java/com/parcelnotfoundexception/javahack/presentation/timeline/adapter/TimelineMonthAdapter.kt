package com.parcelnotfoundexception.javahack.presentation.timeline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parcelnotfoundexception.javahack.R

class TimelineMonthAdapter : RecyclerView.Adapter<TimelineMonthViewHolder>() {

    var months: List<String> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineMonthViewHolder {
        return TimelineMonthViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_month_selector,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = months.size

    override fun onBindViewHolder(holder: TimelineMonthViewHolder, position: Int) {
        holder.bind(months[position], false)
    }

}

class TimelineMonthViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(month: String, selected: Boolean) {
        (itemView as TextView).text = month
    }

}