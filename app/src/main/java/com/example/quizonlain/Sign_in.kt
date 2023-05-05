package com.example.quizonlain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizonlain.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class Sign_in : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
    }

    private val auth = FirebaseAuth.getInstance()

    private fun start() {
        binding.apply {
            btLogin.setOnClickListener {

                val email = edMail.text.toString()
                val password = edPass.text.toString()

                if (email.isEmpty() || password.isEmpty()) {
                    return@setOnClickListener
                }

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        goToProfile()
                    } else {
                        Toast.makeText(
                            this@Sign_in,
                            "${task.exception?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }

            btForgotPassword.setOnClickListener {
                startActivity(Intent(this@Sign_in, ForgotPassword::class.java))
            }

            btReg.setOnClickListener {
                startActivity(Intent(this@Sign_in, Sign_up::class.java))
                finish()
            }
        }

    }

    fun goToProfile() {
        startActivity(Intent(this@Sign_in, Profile::class.java))
    }
}