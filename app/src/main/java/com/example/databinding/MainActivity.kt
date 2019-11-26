package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Declare an instance of object
    private var mycontact: Contact= Contact("Khoo","12345")
    //lateint = late initialise
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //Binding the UI to the program variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.contact = mycontact
        binding.buttonDone.setOnClickListener{
            changeContact(it)
        }
        //binding.contact?.name = editTextName.text.tostring()
    }

    private fun changeContact(it:View){
        binding.apply {
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextAge.text.toString()
            this.invalidateAll()
            //refresh the UI
        }

    }

}
