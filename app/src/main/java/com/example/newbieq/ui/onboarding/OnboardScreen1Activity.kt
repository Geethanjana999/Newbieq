package com.example.newbieq.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newbieq.R
import com.example.newbieq.databinding.ActivityOnboardScreen1Binding

class OnboardScreen1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardScreen1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding using ViewBinding
        binding = ActivityOnboardScreen1Binding.inflate(layoutInflater)
        setContentView(binding.root) // Use the root of the binding instead of R.layout.activity_onboard_screen1

        // Add your logic here, for example, button click to move to the next screen
        binding.btnNext.setOnClickListener {
            // Move to the next onboarding screen or main app screen
            val intent = Intent(this, OnboardScreen2Activity::class.java)
            startActivity(intent)
        }
    }
}