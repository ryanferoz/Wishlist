package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val items: List<Item>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTextView: TextView
        val costTextView: TextView
        val urlTextView: TextView

        init {
            itemTextView = itemView.findViewById(R.id.itemName)
            costTextView = itemView.findViewById(R.id.price)
            urlTextView = itemView.findViewById(R.id.url)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.itemTextView.text = item.name
        holder.costTextView.text = item.price
        holder.urlTextView.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}