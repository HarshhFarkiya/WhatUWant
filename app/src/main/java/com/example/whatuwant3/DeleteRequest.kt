package com.example.whatuwant3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.whatuwant3.databinding.ActivityDeleteRequestBinding
import com.example.whatuwant3.databinding.ActivityTrackApplicationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteRequest : AppCompatActivity() {
    private lateinit var binding2 : ActivityDeleteRequestBinding
    private lateinit var databse2 : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2= ActivityDeleteRequestBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        val username2 : String = binding2.getuser2.text.toString()

        binding2.getdetails2.setOnClickListener()
        {

            //if(username2.isNotEmpty())
            //{
            deleteData(username2)
            //}
            //else
            //{
             //   Toast.makeText(this, "Please enter the username...", Toast.LENGTH_SHORT).show()
            //}
        }
    }

    private fun deleteData(username: String) {
        databse2= FirebaseDatabase.getInstance().getReference("details")
        databse2.child(username).removeValue().addOnSuccessListener {
            Toast.makeText(this, "Your Request is canceled successfully...", Toast.LENGTH_SHORT).show()
        }

    }


}