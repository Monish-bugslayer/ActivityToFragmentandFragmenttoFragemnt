package com.example.activitytofragmentandfragmenttofragemnt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.activitytofragmentandfragmenttofragemnt.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding?=null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstFragment=FirstFragment()
        //moving from second fragment to Main activity
        binding.backToActivity.setOnClickListener { Intent(context,MainActivity::class.java).also { startActivity(it) }}

        //Moving from second fragment to first fragment


//        binding.backToActivity.setOnClickListener {
//            fragmentManager?.beginTransaction()?.apply {
//                replace(R.id.constraint_layout,firstFragment).
//                addToBackStack(null).commit()
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}