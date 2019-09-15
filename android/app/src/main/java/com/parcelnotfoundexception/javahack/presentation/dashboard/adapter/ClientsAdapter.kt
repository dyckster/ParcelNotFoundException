package com.parcelnotfoundexception.javahack.presentation.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.domain.model.dashboard.Client
import kotlinx.android.synthetic.main.item_dashboard_client.view.*

class ClientsAdapter : RecyclerView.Adapter<ClientViewHolder>() {

    var clients: List<Client> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_dashboard_client,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = clients.size

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.bind(clients[position])
    }
}

class ClientViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(client: Client) {
        with(itemView) {
            clientName.text = client.name.replace(" ", "\n")
            Glide.with(this)
                .load(client.profileIcon)
                .into(clientAvatar)
        }
    }

}