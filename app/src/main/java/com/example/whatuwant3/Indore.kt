package com.example.whatuwant3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class Indore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indore)
        val arrayList1 = ArrayList<String>(5)
        arrayList1.add("Aakash Gupta at Vijay Nagar")//Adding object in arraylist
        arrayList1.add("Vijay Pal at Khandwa Naka")
        arrayList1.add("Prakash Jain at Bhawarkua Square")
        arrayList1.add("Rohan Das at Tejaji Nagar")

        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, arrayList1
        )

        val listview = findViewById<ListView>(R.id.listelectrician)
        listview.adapter = arrayAdapter
        listview.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as String
            val Intent = Intent(this, Hire::class.java)
            startActivity(Intent)
        }
    }
}


