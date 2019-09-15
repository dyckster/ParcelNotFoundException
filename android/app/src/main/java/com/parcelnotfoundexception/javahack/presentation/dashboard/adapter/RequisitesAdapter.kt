package com.parcelnotfoundexception.javahack.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.parcelnotfoundexception.javahack.R
import kotlinx.android.synthetic.main.item_requisite.view.*

class RequisitesAdapter : RecyclerView.Adapter<RequisitesAdapter.RequisitesViewHolder>() {

    var items: List<Pair<String, String>> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequisitesViewHolder {
        return RequisitesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_requisite,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RequisitesViewHolder, position: Int) =
        holder.bind(items[position])

    inner class RequisitesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(requisites: Pair<String, String>) {
            with(itemView) {
                requisiteTitle.text = requisites.first
                requisiteValue.text = requisites.second
            }
        }

    }
}