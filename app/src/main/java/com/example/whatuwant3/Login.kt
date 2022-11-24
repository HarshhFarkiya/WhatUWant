package com.example.whatuwant3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.whatuwant3.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var database: DatabaseReference
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener {


            //binding.logintext.text = username
            val email = binding.email.text.toString()
            val pass = binding.pass.text.toString()


            if (email != "" && pass != "") {

                if(email=="admin123@gmail.com" && pass=="admin")
                {
                    val Intent = Intent(this, Admin::class.java)
                    //Intent.putExtra("username", username)
                    startActivity(Intent)
                }
                else {
                    auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Successfully Singed Up", Toast.LENGTH_SHORT)
                                .show()
                            val Intent = Intent(this, Navigation_user::class.java)
                            //Intent.putExtra("username", username)
                            startActivity(Intent)

                        } else {
                            Toast.makeText(this, "Singed Up Failed!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            else
            {
                Toast.makeText(this, "All fields are necessary!!", Toast.LENGTH_SHORT).show()
            }
        }

            }

        }

