package com.example.quizonlain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.quizonlain.databinding.ActivityQuizBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class QuizActivity : AppCompatActivity() {
    private lateinit var NavController:NavController
    lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainConteiner) as NavHostFragment
        NavController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setupWithNavController(bottomNavigationView,NavController)

    }
}