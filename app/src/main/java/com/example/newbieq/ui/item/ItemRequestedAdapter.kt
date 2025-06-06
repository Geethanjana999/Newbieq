package com.example.newbieq.ui.item


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newbieq.R
import com.example.newbieq.databinding.RequestedItemCardBinding
import com.example.newbieq.model.Item


class ItemRequestedAdapter(private var items: List<Item>): RecyclerView.Adapter<ItemRequestedAdapter.RequestedItemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestedItemViewHolder {
        val binding = RequestedItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RequestedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RequestedItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class RequestedItemViewHolder(private val binding: RequestedItemCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item) {
            // Bind the item data to the UI
            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .into(binding.requestedItemImage)

            binding.requestedUsername.text = item.email
            binding.requestedTitle.text = item.name

            binding.confirmBtn.setOnClickListener {
                // Handle the button click, like making a request
                Toast.makeText(binding.root.context, "Confirm ${item.name}", Toast.LENGTH_SHORT)
                    .show()
            }

            // Optionally handle the heart icon click (add/remove from favorites)
            binding.deleteBtn.setOnClickListener {
                // Handle heart icon click, like adding to favorites
                Toast.makeText(binding.root.context, "Delete ${item.name}", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Item>) {
        items = newItems;
        notifyDataSetChanged()
    }
}
