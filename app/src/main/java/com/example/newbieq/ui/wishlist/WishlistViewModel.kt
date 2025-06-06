package com.example.newbieq.ui.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newbieq.R
import com.example.newbieq.model.Item

class WishlistViewModel : ViewModel() {

    private val _wishlistItems = MutableLiveData<List<Item>>()
    val wishlistItems: LiveData<List<Item>> get() = _wishlistItems

    private val allItems = listOf(
        Item("2nd Year Text Book", "Used by 2nd year student for 1 year, Packed with notes and ready for use", R.drawable.home_item_3, "Book", "University of Oxford", "johndoe99@.com", "123456789", "Accepted"),
        Item("Blender", "Used for baking and cooking", R.drawable.slider_image_2, "Book", "University of Harvard", "wizard@example.com", "987654321","Accepted"),
        Item("Table", "Used for dining, study and living", R.drawable.table, "Furniture", "University of Stanford", "max99@.com", "456123789", "Accepted"),
        Item("Asus Laptop", "Used for work and study", R.drawable.slider_image_3, "Electronic", "Oxford", "booklover@example.com", "123456789", "Pending"),
        Item("Lamp", "Energy efficient lamp", R.drawable.items_lamp, "Electronic", "University of Harvard", "david@gmail.com", "987654321","Pending"),
        Item("Clock", "Nice clock, perfect for study", R.drawable.items_clock, "Electronic", "University of Stanford", "jane345@example.com", "789654123", "Accepted"),
        Item("Maths Text Book", "Advanced maths textbook", R.drawable.home_item_6, "Book", "University of Stanford", "lucas576@example.com", "789654123", "Accepted")
    )

    init {
        loadItemsByCategory("Accepted")
    }



    fun loadItemsByCategory(acceptedOrPending: String) {
        _wishlistItems.value = allItems.filter { it.acceptedOrPending == acceptedOrPending }
    }

}