package com.example.quizonlain

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.example.quizonlain.databinding.FragmentHomeBinding
import com.example.quizonlain.databinding.FragmentQuizBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private  var _binding : FragmentHomeBinding? = null
    private val  binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.fabSettings.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        settings()
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun settings() {
        val sp = PreferenceManager.getDefaultSharedPreferences(context!!)
        val signature = sp.getString("signature", "")
        val defaultReplyAction = sp.getString("reply", "")
        val sync = sp.getBoolean("sync", true)
        val notifications = sp.getBoolean("notifications", true)
        val volume = sp.getInt("volume_notifications", 0)
        binding.tvSignature.text = "Signature: $signature"
        binding.tvReply.text = "Default reply: $defaultReplyAction"
        binding.tvSync.text = "Sync: $sync"
        binding.tvNotifications.text = "Disable notifications: $notifications"
        binding.pbVolume.setProgress(volume, true)

    }


}