package com.example.quizonlain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.quizonlain.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import com.google.firebase.ktx.Firebase

class Profile : AppCompatActivity() {

        lateinit var binding: ActivityProfileBinding
        private val auth = Firebase.auth
        private val auth2 = FirebaseAuth.getInstance()
        private val db = FirebaseDatabase.getInstance().getReference("User")

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityProfileBinding.inflate(layoutInflater)
            setContentView(binding.root)
            start()
        }

        private fun start(){
            binding.apply {

                btSignOut.setOnClickListener {
                    Firebase.auth.signOut()
                    startActivity(Intent(this@Profile,Sign_in::class.java))
                    finish()
                }

                btUpdatePassword.setOnClickListener {
                    startActivity(Intent(this@Profile,UpadatePassword::class.java))
                }
                btStartQuiz.setOnClickListener {
                    startActivity(Intent(this@Profile,Quiz::class.java))
                }

            }
        }
    }