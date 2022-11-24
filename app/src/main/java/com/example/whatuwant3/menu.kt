package com.example.whatuwant3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val hire: Button = findViewById(R.id.hirebtn1)
        hire.setOnClickListener()
        {
            val Intent = Intent(this, Hire::class.java)
            startActivity(Intent)
        }

        val hire2: Button = findViewById(R.id.hirebtn2)
        hire2.setOnClickListener()
        {
            val Intent = Intent(this, Hire::class.java)
            startActivity(Intent)
        }

        val hire3: Button = findViewById(R.id.hirebtn3)
        hire3.setOnClickListener()
        {
            val Intent = Intent(this,Hire::class.java)
            startActivity(Intent)
        }

        val hire4: Button = findViewById(R.id.hirebtn4)
        hire4.setOnClickListener()
        {
            val Intent = Intent(this, Hire::class.java)
            startActivity(Intent)
        }
    }
}