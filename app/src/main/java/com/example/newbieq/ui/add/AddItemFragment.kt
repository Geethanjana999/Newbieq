package com.example.newbieq.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.newbieq.R

class AddItemFragment : Fragment(R.layout.fragment_add_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get references to UI elements
        //val edtItemName = view.findViewById<EditText>(R.id.edtItemName)
        //val btnSave = view.findViewById<Button>(R.id.btnSave)

        // Set button click listener
        //btnSave.setOnClickListener {
            // Handle saving the item
           // val itemName = edtItemName.text.toString()
            // You can add logic to save the item, for example, in a database or list.
        //}
    }
}