package com.example.quizonlain

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quizonlain.databinding.ActivityQuizBinding

class Quiz : AppCompatActivity() {
    lateinit var binding: ActivityQuizBinding
    var n = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ReplaceFragment(Quiz1())
        binding.apply {
            if (n == 0) {
                btA.setOnClickListener {
                    /*btA.setBackgroundColor(Color.RED)*/
                    Toast.makeText(
                        this@Quiz,
                        "Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                btB.setOnClickListener {
                   /* btB.setBackgroundColor(Color.RED)*/
                    Toast.makeText(
                        this@Quiz,
                        "Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                btC.setOnClickListener {
                  /*  btC.setBackgroundColor(Color.GREEN)*/
                    Toast.makeText(
                        this@Quiz,
                        "Right!",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                btD.setOnClickListener {
                /*    btD.setBackgroundColor(Color.RED)*/
                    Toast.makeText(
                        this@Quiz,
                        "Wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


        }
        start()
    }
    private fun start(){
        binding.btFirstQuiz.setOnClickListener {
            //პირველი ფრაგმენტის გამოჩენა
            ReplaceFragment(Quiz1())
        }
        binding.btSecondQuiz.setOnClickListener {
            //მეორე ფრაგმენტის გამოჩენა
            ReplaceFragment(Quiz2())
            n++
            binding.apply {
                if (n != 0) {
                    btA.setOnClickListener {
                         btA.setBackgroundColor(Color.RED)
                        Toast.makeText(
                            this@Quiz,
                            "Wrong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    btB.setOnClickListener {
                   btB.setBackgroundColor(Color.RED)
                        Toast.makeText(
                            this@Quiz,
                            "Wrong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    btC.setOnClickListener {
                   btC.setBackgroundColor(Color.RED)
                        Toast.makeText(
                            this@Quiz,
                            "Wrong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    btD.setOnClickListener {
                  btD.setBackgroundColor(Color.GREEN)
                        Toast.makeText(
                            this@Quiz,
                            "Right!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    //for Fragment
    private fun ReplaceFragment(fragment: Fragment){
        //ფრაგმენტის ლოგიკა
        val fragmentManager = supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentConteiner,fragment)
        fragmentTransaction.commit()

    }


}