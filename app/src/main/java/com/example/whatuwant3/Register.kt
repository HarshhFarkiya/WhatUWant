package com.example.whatuwant3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatuwant3.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.io.*


class Register : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auth = FirebaseAuth.getInstance()
        binding.submitbutton.setOnClickListener {

            val email = binding.emailentry.text.toString()
            val name = binding.nameentry.text.toString()
            val mobile= binding.mobileentry.text.toString()
            val passw1 = binding.Password.text.toString()
            val passw2=binding.Passwordconfrm.text.toString()
            val type= "Owner"
            if(passw1!=passw2)
            {
                Toast.makeText(applicationContext, "Password doesn't match, try again...", Toast.LENGTH_SHORT).show()
            }
            else if(name !="" && email !="" && mobile!="" && passw1!="" && passw2!="") {
                database = FirebaseDatabase.getInstance().getReference("User")
                val user = User(name,email, mobile,passw1)
                auth.createUserWithEmailAndPassword(email, passw1).addOnCompleteListener{
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                    }
                }
                database.child(name).setValue(user).addOnSuccessListener {
                    Toast.makeText(applicationContext, "Submitted successfully", Toast.LENGTH_SHORT).show()
                    val a = Intent(this, Login::class.java)
                    startActivity(a)


                }
            }
            else
            {
                Toast.makeText(this, "All fields are necessary", Toast.LENGTH_SHORT).show()
            }
        }
        val login:Button = findViewById(R.id.account)
        login.setOnClickListener()
        {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)
        }

    }
}
