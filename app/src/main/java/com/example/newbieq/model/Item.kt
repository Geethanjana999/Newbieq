package com.example.newbieq.model
//home page
data class Item(
    val name: String,
    val description: String, // Change from String to Int
    val imageUrl: Int,
    val category: String,
    val university: String,
    val email: String,
    val phoneNumber: String,
    val acceptedOrPending:String
)
