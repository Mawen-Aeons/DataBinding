package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit = late initialize
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName( "See")
    private val myContactNumber: MyContactNumber = MyContactNumber("Number")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonSetName.setOnClickListener{
            //it = object (button) associated to an event
            addNickName(it)
        }

        binding.myName = myName

        binding.buttonSetContactNumber.setOnClickListener{

            addContactNumber(it)
        }
        binding.myContactNumber = myContactNumber

    }

    private fun addNickName(it: View?){
        //apply = execute multiple setters
        binding.apply{
            myName?.name = editTextName.text.toString()
            this.invalidateAll()

        }
    }

    private fun addContactNumber(it: View?){

        binding.apply{
            myContactNumber?.ContactNumber = editTextContactNumber.text.toString()
            this.invalidateAll()
        }
    }
}
