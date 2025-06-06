package com.example.newbieq.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newbieq.R
import com.example.newbieq.databinding.ItemCardBinding
import com.example.newbieq.model.Item

class HomeItemAdapter(private var items: List<Item>) : RecyclerView.Adapter<HomeItemAdapter.ItemViewHolder>() {

    // Creates the view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    // Binds data to the view holder
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    // Returns the size of the list
    override fun getItemCount(): Int = items.size

    // ViewHolder to bind data to the individual card
    class ItemViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            // Bind the item data to the UI
            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .into(binding.itemImage)

            binding.requestButton.setOnClickListener {
                // Handle the button click, like making a request
                Toast.makeText(binding.root.context, "Request for ${item.name}", Toast.LENGTH_SHORT).show()
            }

            // Optionally handle the heart icon click (add/remove from favorites)
            binding.itemHeartIcon.setOnClickListener {
                // Handle heart icon click, like adding to favorites
                Toast.makeText(binding.root.context, "Favorite ${item.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Update items list and notify adapter
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Item>) {
        items = newItems // Update the list with new data
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}