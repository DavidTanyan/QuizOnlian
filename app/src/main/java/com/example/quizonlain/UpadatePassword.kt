package com.example.quizonlain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizonlain.databinding.ActivityUpadatePasswordBinding
import com.google.firebase.auth.FirebaseAuth
class UpadatePassword : AppCompatActivity() {

        private lateinit var binding: ActivityUpadatePasswordBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityUpadatePasswordBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.apply {
                btUpdatePassword.setOnClickListener {
                    val password = edPassword.text.toString()

                    FirebaseAuth.getInstance().currentUser?.updatePassword(password)?.addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this@UpadatePassword, "password updated", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this@UpadatePassword, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }