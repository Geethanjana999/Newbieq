package com.example.newbieq.ui.wishlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newbieq.R
import com.google.android.material.tabs.TabLayout

class WishlistFragment : Fragment(R.layout.fragment_wishlist) {

    private lateinit var wishlistRecyclerView: RecyclerView
    private lateinit var wishlistTabLayout: TabLayout
    private lateinit var adapter: WishlistAdapter

    private val wishlistViewModel: WishlistViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        wishlistRecyclerView = view.findViewById(R.id.wishlistRecyclerView)
        wishlistTabLayout = view.findViewById(R.id.wishlistTabLayout)

        // Set up RecyclerView
        wishlistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = WishlistAdapter(emptyList())
        wishlistRecyclerView.adapter = adapter

        // Observe ViewModel Data
        wishlistViewModel.wishlistItems.observe(viewLifecycleOwner) { items ->
            adapter.updateData(items)
        }

        // Tab Selection Logic
        wishlistTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> wishlistViewModel.loadItemsByCategory("Accepted")
                        1 -> wishlistViewModel.loadItemsByCategory("Pending")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Load Default Category (Accepted)
        wishlistViewModel.loadItemsByCategory("Accepted")
    }
}