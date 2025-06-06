//package com.example.newbieq.ui.auth
//
//import android.app.ActivityOptions
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.newbieq.R
//import com.example.newbieq.databinding.ActivityLoginBinding
//import com.example.newbieq.ui.home.HomeActivity  // Import HomeActivity
//
//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnLogin.setOnClickListener {
//            val email = binding.etEmail.text.toString()
//            val password = binding.etPassword.text.toString()
//
//            // You can perform validation and login logic here
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                // Proceed with login logic
//                // For example: FirebaseAuth or any other backend service
//
//                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
//
//                loginUser(email, password)
//
//                // Implement login logic here, e.g., Firebase login
//                // FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//            } else {
//                // If fields are empty, show an error message
//                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        binding.txtSignup.setOnClickListener {
//            val intent = Intent(this, SignupActivity::class.java)
//            // Apply animation for transition
//            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
//            startActivity(intent, options.toBundle())
//        }
//    }
//
//    private fun loginUser(email: String, password: String) {
//        val isLoginSuccessful = simulateLogin(email, password)
//
//        if (isLoginSuccessful) {
//
//            val intent = Intent(this, HomeActivity::class.java)
//
//            // Apply animation for transition
//            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
//            startActivity(intent, options.toBundle())
//
//            finish()  // Close the LoginActivity after successful login
//        } else {
//            // Handle login failure (wrong credentials)
//            Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    // Simulate a login check for now (replace this with real authentication logic)
//    private fun simulateLogin(email: String, password: String): Boolean {
//        // Add real authentication logic here (Firebase, API call, etc.)
//        return email == "a@gmail.com" && password == "123"
//    }
//}


package com.example.newbieq.ui.auth

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newbieq.MainActivity
import com.example.newbieq.R
import com.example.newbieq.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString()
            val password = binding.loginPasswordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            // Apply animation for transition
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent, options.toBundle())
        }
    }

    private fun loginUser(email: String, password: String) {
        val isLoginSuccessful = simulateLogin(email, password)

        if (isLoginSuccessful) {
            // Once login is successful, navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)

            // Apply the transition animation for launching MainActivity
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent, options.toBundle())

            // Finish LoginActivity to prevent back navigation
            finish()

            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun simulateLogin(email: String, password: String): Boolean {
        return email == "geeth@gmail.com" && password == "123"
    }
}