package com.example.quizonlain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizonlain.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
    }
    private  fun start(){
        binding.btForgotPassword.setOnClickListener {
            val email = binding.edMail.text.toString()
            if (email.isEmpty() ||!email.contains('@')){
                Toast.makeText(this@ForgotPassword, "Error Email is not correct!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this, "link sent", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}