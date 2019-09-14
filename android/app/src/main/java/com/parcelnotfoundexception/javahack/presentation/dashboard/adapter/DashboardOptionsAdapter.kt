package com.parcelnotfoundexception.javahack.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parcelnotfoundexception.javahack.R
import kotlinx.android.synthetic.main.item_dashboard_option.view.*

class DashboardOptionsAdapter(private val listener: (OptionItem) -> Unit) :
    RecyclerView.Adapter<DashboardOptionsAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return DashboardViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_dashboard_option, parent, false
            )
        )
    }

    override fun getItemCount() = OptionItem.values().size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val item = OptionItem.values()[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.invoke(item) }
    }

    inner class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(optionItem: OptionItem) {
            with(itemView) {
                itemTitle.text = optionItem.title
            }
        }

    }

}