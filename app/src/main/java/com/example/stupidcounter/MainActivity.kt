package com.example.stupidcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare an instance of the ViewModel
    private lateinit var counterViewModel: CounterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the ViewModel
        counterViewModel = ViewModelProviders.of(this)
            .get(CounterViewModel::class.java)

        //Add an observer to the ViewModel
        counterViewModel.counter.observe(this,
            Observer {
                if (counterViewModel.counter.value == 10){
                    goodJob()
                }
            }
        )


        buttonIncrease.setOnClickListener {
            counterViewModel.increment()
            textViewCounter.text = counterViewModel.counter.value.toString()

        }

        buttonDecrease.setOnClickListener {
            counterViewModel.decrement()
            textViewCounter.text = counterViewModel.counter.value.toString()
        }
    }

        private fun goodJob(){
            Toast.makeText(applicationContext,"Congratulation!!!", Toast.LENGTH_LONG).show()
        }

        override fun onDestroy() {
            Log.d("MainActivity", "OnDestroy")
            super.onDestroy()
        }


        }

