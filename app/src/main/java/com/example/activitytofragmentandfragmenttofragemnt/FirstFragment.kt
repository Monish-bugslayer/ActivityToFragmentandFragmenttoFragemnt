package com.example.activitytofragmentandfragmenttofragemnt

import android.content.Context
import android.os.Bundle
import android.system.Os.remove
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.activitytofragmentandfragmenttofragemnt.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var  _binding:FragmentFirstBinding?=null
    private val binding get() =_binding!!
    //2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFirstBinding.inflate(inflater,container,false)
        println("OnCreateView")
        return binding.root

    }
    //3
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("OnViewCreated")
        val secondFragment=SecondFragment()

        fragmentManager?.findFragmentById(R.id.constraint_layout)?.let { fragmentManager?.beginTransaction()?.remove(it) }
        binding.firstFragmentToSecondFragment.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.constraint_layout,secondFragment)
                setReorderingAllowed(true)
                addToBackStack("booya").commit()
            }
        }

    }

    override fun onDestroyView() {
        println("Destroyed view")
        super.onDestroyView()
        _binding=null

    }

    override fun onResume() {
        println("Resumed")
        super.onResume()
    }
    //1
    override fun onAttach(context: Context) {
        println("Attach")
        super.onAttach(context)
    }

    override fun onDestroy() {
        println("destroy")
        super.onDestroy()
    }

    override fun onDetach() {
        println("Detach")
        super.onDetach()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        println("OnViewStateRestored")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("SavedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        println("Fragment 1 started")
    }
}