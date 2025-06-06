package com.example.newbieq.ui.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newbieq.R
import com.example.newbieq.model.Item
import com.example.newbieq.model.ItemData

class ItemViewModel: ViewModel() {

    private val _items = MutableLiveData<List<Item>>() // Live data for items
    val items: LiveData<List<Item>> = _items

    private val allItems = mutableListOf<Item>() // Stores full item list for filtering

    init {
        fetchItems()
    }

    fun fetchItems() {
        // Simulating fetching data (replace with API or DB call)
        allItems.clear()
        allItems.addAll(
            listOf(
                Item("Physics Text Book", "Description 1", R.drawable.slider_image_1, "Books", "University A", "harrison@example.com", "123-456-7890",""),
                Item("Macbook Pro 2020", "Description 2", R.drawable.itmes_macbook, "Furniture", "University B", "john@example.com", "987-654-3210", ""),
                Item("Blender", "Description 3", R.drawable.items_blender, "Electronics", "University C", "jane@example.com", "555-555-5555", ""),
                Item("Maths Text Book", "Description 4", R.drawable.home_item_6, "Books", "University D", "bob@example.com", "111-222-3333", ""),
                Item("Clock", "Description 5", R.drawable.items_clock, "Electronics", "University E", "alice@example.com", "999-888-7777", ""),
                Item("Table Lamp", "Description 5", R.drawable.items_lamp, "Electronics", "University F", "max@example.com", "999-888-7777", ""),
                Item("Psychology Text Book", "Description 5", R.drawable.home_item_1, "Books", "University G", "david@example.com", "999-888-7777", ""),
                Item("iPad Pro 2022", "Description 5", R.drawable.items_tab, "Electronics", "University G", "williom@example.com", "999-888-7777", "")
                )
        )
        _items.value = allItems // Update LiveData
    }

    fun filterItems(query: String) {
        if (query.isEmpty()) {
            _items.value = allItems // Reset to all items if query is empty
        } else {
            _items.value = allItems.filter { it.name.contains(query, ignoreCase = true) }
        }
    }
}