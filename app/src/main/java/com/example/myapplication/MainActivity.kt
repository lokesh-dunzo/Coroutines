package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val time = measureTimeMillis {
                val one = sampleOne()
                val two = sampleTwo()
                println("The answer is ${one + two}")
            }
            while(true) {
                delay(100);
                Log.d("Hello","Lokesh")
                //println("Completed in $time ms")
            }
        }
        println("EOF")
        lifecycleScope.launch{
            while(true) {
                delay(100);
                Log.d("Hello","Lokesh111")
                //println("Completed in $time ms")
            }
        }
        var buttonView : Button = findViewById(R.id.button)
        buttonView.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this , MainActivity2 :: class.java))
            finish()
        });
    }

    private suspend fun sampleOne(): Int {
        println( "sampleOne"+System.currentTimeMillis())
        delay(1000L) // pretend we are doing something useful here
        return 10
    }

    private suspend fun sampleTwo(): Int {
        println( "sampleTwo"+System.currentTimeMillis())
        delay(1000L) // pretend we are doing something useful here, too
        return 10
    }
}