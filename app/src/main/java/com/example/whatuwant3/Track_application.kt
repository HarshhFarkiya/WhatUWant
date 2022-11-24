package com.example.whatuwant3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.whatuwant3.databinding.ActivityTrackApplicationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Track_application : AppCompatActivity() {
    private lateinit var binding : ActivityTrackApplicationBinding
    private lateinit var databse :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTrackApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getdetails.setOnClickListener()
        {
            val username : String = binding.getuser.text.toString()
            if(username.isNotEmpty())
            {
                readData(username)
            }
            else
            {
                Toast.makeText(this, "Please enter the username...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(username: String) {
        databse=FirebaseDatabase.getInstance().getReference("details")
        databse.child(username).get().addOnSuccessListener {
            if(it.exists())
            {
                val name = it.child("name").value
                val address = it.child("address").value
                val phone = it.child("phone").value
                val employee = it.child("employee").value
                val status = it.child("status").value
                binding.getname.text = name.toString()
                binding.getphone.text = phone.toString()
                binding.getaddress.text = address.toString()
                binding.getemployee.text = employee.toString()
                binding.status.text = status.toString()


            }
            else
            {
                Toast.makeText(this, "NO request found...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}