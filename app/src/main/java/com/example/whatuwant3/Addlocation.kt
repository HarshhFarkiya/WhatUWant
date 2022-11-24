package com.example.whatuwant3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.whatuwant3.databinding.ActivityAddLocationBinding
import com.example.whatuwant3.databinding.ActivityRegisterBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Addlocation : AppCompatActivity() {
    private lateinit var binding : ActivityAddLocationBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addnewlocation.setOnClickListener()
        {
        database = FirebaseDatabase.getInstance().getReference("Locations")
        val loca = binding.newlocation.text.toString()
        val user = location(loca)
        database.child(loca).setValue(user).addOnSuccessListener {
            Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
        }


        }
    }
}