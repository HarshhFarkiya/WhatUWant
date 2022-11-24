package com.example.whatuwant3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.whatuwant3.databinding.ActivityAdminBinding
import com.google.firebase.database.DatabaseReference

class Admin : AppCompatActivity() {
    private lateinit var binding : ActivityAdminBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        val btn : ImageButton = findViewById(R.id.addlocation)
        btn.setOnClickListener()
        {
            val Intent = Intent(this, Addlocation::class.java)
            startActivity(Intent)
        }
        val btn2 : ImageButton = findViewById(R.id.checkreq)
        btn2.setOnClickListener()
        {

            val Intent = Intent(this, Userlist::class.java)
            startActivity(Intent)
        }
        val btn3 : ImageButton = findViewById(R.id.logout)
        btn3.setOnClickListener()
        {
            val Intent = Intent(this, Login::class.java)
            startActivity(Intent)
        }

    }
}

