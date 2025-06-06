package com.example.newbieq.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newbieq.R
import com.example.newbieq.model.Item


class HomeViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private val itemList = listOf(
        Item("Psychology Book", "Description 1", R.drawable.home_item_1, "Books", "University A", "harrison@example.com", "123-456-7890",""),
        Item("Physics Book", "Description 2", R.drawable.home_item_2, "Furniture", "University B", "john@example.com", "987-654-3210", ""),
        Item("Art Book", "Description 3", R.drawable.home_item_3, "Electronics", "University C", "jane@example.com", "555-555-5555", ""),
        Item("Painting Book", "Description 4", R.drawable.home_item_4, "Books", "University D", "bob@example.com", "111-222-3333", ""),
        Item("Maths Book", "Description 5", R.drawable.home_item_5, "Electronics", "University E", "alice@example.com", "999-888-7777", ""),
        Item("IT Book", "Description 5", R.drawable.home_item_6, "Electronics", "University E", "alice@example.com", "999-888-7777", "")
    )

    // Method to fetch the items (simulated here with a static list)
    fun fetchItems() {
        _items.value = itemList
    }

    // Filter items based on the search query
    fun filterItems(query: String) {
        val filteredItems = itemList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        _items.postValue(filteredItems)
    }

    // Filter items by category
    fun filterItemsByCategory(category: String) {
        val filteredItems = itemList.filter {
            it.name.equals(category, ignoreCase = true)
        }
        _items.postValue(filteredItems)
    }
}