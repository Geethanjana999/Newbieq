package com.example.newbieq.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newbieq.databinding.FragmentItemBinding


class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding
    private lateinit var itemRequestedAdapter: ItemRequestedAdapter

    private val itemViewModel: ItemViewModel by viewModels() // ViewModel for items

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and Adapter
        itemRequestedAdapter = ItemRequestedAdapter(emptyList()) // Empty list initially
        binding.itemRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.itemRecyclerView.adapter = itemRequestedAdapter

        // Observe LiveData from ItemViewModel
        itemViewModel.items.observe(viewLifecycleOwner, Observer { items ->
            itemRequestedAdapter.updateItems(items) // Update RecyclerView
        })

        // Fetch items when fragment is created
        itemViewModel.fetchItems()

        // Search functionality (filter items dynamically)
        binding.ItemSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                itemViewModel.filterItems(newText ?: "")
                return true
            }
        })
    }
}