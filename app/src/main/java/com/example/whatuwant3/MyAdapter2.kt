package com.example.whatuwant3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class MyAdapter2(private val userlist : ArrayList<location>) : RecyclerView.Adapter<MyAdapter2.MyviewHolder2>() {
    private lateinit var database : DatabaseReference
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder2{

        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.avalaible, parent ,false)
        return MyviewHolder2(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter2.MyviewHolder2, position: Int) {

        val currentitem = userlist[position]
        holder.location.text=currentitem.location


    }

    override fun getItemCount(): Int {

        return userlist.size
    }

    class MyviewHolder2(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val location : TextView = itemView.findViewById(R.id.avalaibllocations)

    }


}