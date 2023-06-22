package com.example.quizonlain

import android.graphics.Color.*
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quizonlain.databinding.FragmentQuizBinding


class QuizFragment : Fragment(R.layout.fragment_quiz) {
private  var _binding : FragmentQuizBinding? = null
    private val  binding get() =_binding!!
    private var timer :CountDownTimer? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    var count =0
    fun init(){

        binding.apply {
            textContQv.setVisibility(View.GONE)
            fotoquiz.setVisibility(View.GONE)
            quiztimertext.setVisibility(View.GONE)
            btA.setVisibility(View.GONE)
            btB.setVisibility(View.GONE)
            btC.setVisibility(View.GONE)
            btD.setVisibility(View.GONE)
            quizqula.setVisibility(View.GONE)
            btStartQuiz.setVisibility(View.VISIBLE)
            btStartQuiz.setOnClickListener {
                quiztimertext.setVisibility(View.VISIBLE)
                starCountDownTimer(20000,true)
                btStartQuiz.setVisibility(View.GONE)
                fotoquiz.setVisibility(View.VISIBLE)
                textContQv.text = "1 . რომელია სომხეთის დედაქალაქი?"
                textContQv.setVisibility(View.VISIBLE)
                btA.setVisibility(View.VISIBLE)
                btB.setVisibility(View.VISIBLE)
                btC.setVisibility(View.VISIBLE)
                btD.setVisibility(View.VISIBLE)
                quizqula.setVisibility(View.VISIBLE)
                btA.text = "ერევანი"
                btB.text = "კიევი"
                btC.text = "მინსკი"
                btD.text = "თბილისი"
                wichisCorrect()


            }
        }
    }
        fun wichisCorrect() {

                binding.apply {
                    btA.setOnClickListener {
                        btA.setBackgroundColor(GREEN);
                        count++
                        starCountDownTimer(1, false)
                        quizqula.text = count.toString() + "ქულა"
                    }
                    btB.setOnClickListener {
                        btB.setBackgroundColor(RED);
                        btA.setBackgroundColor(GREEN);
                        starCountDownTimer(1, false)
                    }
                    btC.setOnClickListener {
                        btC.setBackgroundColor(RED);
                        btA.setBackgroundColor(GREEN);
                        starCountDownTimer(1, false)
                    }
                    btD.setOnClickListener {
                        btD.setBackgroundColor(RED);
                        btA.setBackgroundColor(GREEN);
                        starCountDownTimer(1, false)
                    }
                }


    }

 private fun starCountDownTimer (timeMillis:Long,bol: Boolean){
    timer?.cancel()
    timer = object : CountDownTimer(timeMillis,1){
        override fun onTick(timeM: Long) {
           binding.quiztimertext.text = "00:"+timeM.toString()
        }

        override fun onFinish() {
            if (bol == true) {
                binding.quiztimertext.text = "დრო ამოიწურა!"
            }
            else binding.quiztimertext.text = "Stop!"
        }
    }.start()
}

}