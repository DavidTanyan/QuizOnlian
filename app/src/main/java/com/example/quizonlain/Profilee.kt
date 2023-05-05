package com.example.quizonlain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.quizonlain.databinding.ActivityProfileeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Profilee : AppCompatActivity() {
    lateinit var binding: ActivityProfileeBinding
    private val auth = Firebase.auth
    private val auth2 = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("User")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Quizs())
        start()
    }
    private fun start(){
        binding.btNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home ->replaceFragment(Home())
                R.id.menu_quiz ->replaceFragment(Quizs())
                R.id.menu_settings ->replaceFragment(Settings())
                else ->{

                }
            }
            true
        }
    }
    private  fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrasaction = fragmentManager.beginTransaction()
        fragmentTrasaction.replace(R.id.fram_layot,fragment)
        fragmentTrasaction.commit()
    }
}