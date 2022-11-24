package com.example.whatuwant3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.whatuwant3.databinding.ActivityHireBinding
import com.example.whatuwant3.databinding.ActivityRegisterBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class Hire : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var binding : ActivityHireBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHireBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val payment = resources.getStringArray(R.array.payments)
        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_payment, payment)
        val autocompleteTV2 = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView2)
        autocompleteTV2.setAdapter(arrayAdapter2)
        binding.sub.setOnClickListener{
            val name = binding.custentry.text.toString()
            val phone = binding.phone.text.toString()
            val address = binding.add.text.toString()
            val employee = binding.emp.text.toString()
            val status : String = "Pending"
            database = FirebaseDatabase.getInstance().getReference("details")
            val requests = requestsuser(name,phone, address,employee, status)

            database.child(name).setValue(requests).addOnSuccessListener {
                Toast.makeText(applicationContext, "Your request is recorded successfully and you will notify status on your registered mobile number...", Toast.LENGTH_SHORT)
                    .show()
                //val a = Intent(this, Login::class.java)
                //startActivity(a)
            }

        }
    }
}