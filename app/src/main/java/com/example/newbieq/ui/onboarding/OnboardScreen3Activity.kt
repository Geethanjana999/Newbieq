package com.example.newbieq.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newbieq.MainActivity
import com.example.newbieq.R
import com.example.newbieq.databinding.ActivityOnboardScreen3Binding

class OnboardScreen3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardScreen3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding using ViewBinding
        binding = ActivityOnboardScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root) // Use the root of the binding

        // Add your logic here, for example, button click to move to the home screen
        binding.btnNext.setOnClickListener() {
            // Move to HomeFragment after the third onboarding screen
            val intent = Intent(this, MainActivity::class.java) // Assuming you use MainActivity to host fragments
            intent.putExtra("fragment", "home") // Pass extra to indicate which fragment to show
            startActivity(intent)
        }
    }
}