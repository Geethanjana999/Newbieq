package com.example.newbieq.ui.profile

import android.os.Bundle
import android.view.View

import androidx.fragment.app.Fragment

import com.example.newbieq.R
import com.example.newbieq.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)


        // Handle other profile-related actions here
    }
}