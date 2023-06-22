package com.example.quizonlain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.example.quizonlain.databinding.ActivitySignUpBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Sign_up : AppCompatActivity() {
    private val auth = Firebase.auth
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
    }

    private fun start() {
        binding.apply {
            btReg.setOnClickListener {
                val name = edName.text.toString()
                val email = edMail.text.toString()
                val number = edPhone.text.toString()
                val password = edPass.text.toString()

                if ( name.isEmpty()  ) {
                    Toast.makeText(this@Sign_up, "Error Name is empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if(email.isEmpty()|| !email.contains('@')){
                    Toast.makeText(this@Sign_up, "Error Email is not correct!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if(password.isEmpty() || password.length < 5 ||password.contains(' ') )
                {
                    Toast.makeText(this@Sign_up, "Error password minimum 5 simbol!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                if(number.length <9 ||number.isEmpty())
                {
                    Toast.makeText(this@Sign_up, "Error telefon number 9simbol!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this@Sign_up, Sign_in::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@Sign_up, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.btLogin.setOnClickListener {
            startActivity(Intent(this,Sign_in::class.java))
            finish()
        }
    }

}