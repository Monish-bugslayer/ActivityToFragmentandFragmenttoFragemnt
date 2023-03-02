package com.example.activitytofragmentandfragmenttofragemnt


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button=findViewById(R.id.activity_to_fragment_one)
        if(savedInstanceState==null){
            button.setOnClickListener {
                val firstFragment:FirstFragment=FirstFragment()
                supportFragmentManager.beginTransaction().replace(R.id.constraint_layout,firstFragment).addToBackStack(null).commit()
            }
        }
        println("Activity created")
//        activity_to_fragment_one.setOnClickListener { Intent(this,FirstFragment::class.java).also { startActivity(it) } }
    }
    override fun onStart() {
        super.onStart()
        Log.d("OnStart","Activity starts")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume","Activity resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause","Activity paused")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","Activity destroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","Activity stops")
    }

}
