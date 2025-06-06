package com.example.newbieq.ui.wishlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newbieq.R
import com.example.newbieq.model.Item

class WishlistAdapter(private var items: List<Item>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.wishlistItemImage) // Fixed ID
        val itemName: TextView = view.findViewById(R.id.wishlistItemName) // Fixed ID
        val itemDescription: TextView = view.findViewById(R.id.itemDescription)
        val itemUniversity: TextView = view.findViewById(R.id.wishlistUniversity) // Added this field
        val itemEmail: TextView = view.findViewById(R.id.wishlistItemEmail) // Fixed ID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.name
        holder.itemDescription.text = item.description
        holder.itemUniversity.text = item.university // Set University
        holder.itemEmail.text = item.email // Set Email

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .placeholder(R.drawable.bird)
            .into(holder.itemImage)
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<Item>) {
        items = newItems
        notifyDataSetChanged()
    }
}