package com.example.newbieq.ui.auth

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.example.newbieq.R
import com.example.newbieq.databinding.ActivitySignupBinding
import com.example.newbieq.ui.onboarding.OnboardScreen1Activity
import com.example.newbieq.ui.onboarding.OnboardScreen2Activity

class SignupActivity : AppCompatActivity() {

    private  lateinit var binding : ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupBtn.setOnClickListener {
            //val name = binding.nameEditText.text.toString()
            //val university = binding.universityEditText.text.toString()
            //val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            if (password == confirmPassword) {
                // Handle signup logic here (e.g., Firebase)

                // Assuming signup is successful, navigate to OnboardingScreen1Activity

                val intent = Intent(this, OnboardScreen1Activity::class.java)
                val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
                startActivity(intent, options.toBundle())

                Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }


        // Navigate to Login Activity with animation
        binding.loginTextView.setOnClickListener {
            // Start LoginActivity
            val intent = Intent(this, LoginActivity::class.java)

            // Apply animation for transition
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_right)
            startActivity(intent, options.toBundle())
        }

    }
}