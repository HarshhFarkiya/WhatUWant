package com.example.whatuwant3

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

class MyAdapter(private val userlist : ArrayList<requestsuser>) : RecyclerView.Adapter<MyAdapter.MyviewHolder>() {
    private lateinit var database : DatabaseReference
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.requests, parent ,false)
        return MyviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val currentitem = userlist[position]
        holder.name.text=currentitem.name
        holder.phone.text=currentitem.phone
        holder.address.text=currentitem.address
        holder.employee.text=currentitem.employee
        holder.status.text=currentitem.status
        holder.approve.setOnClickListener()
        {
            val c : String = "Approved"
            currentitem.status = c
            holder.status.text=currentitem.status
            database = FirebaseDatabase.getInstance().getReference("details")
            val requests = requestsuser(currentitem.name,currentitem.phone, currentitem.address,currentitem.employee,currentitem.status)
            val x = currentitem.name.toString()
            database.child(x).setValue(requests).addOnSuccessListener {

            }
        }
        holder.delete.setOnClickListener()
        {
            val c : String = "Request denied"
            currentitem.status = c
            holder.status.text=currentitem.status
            database = FirebaseDatabase.getInstance().getReference("details")
            val requests = requestsuser(currentitem.name,currentitem.phone, currentitem.address,currentitem.employee,currentitem.status)
            val x = currentitem.name.toString()
            database.child(x).setValue(requests).addOnSuccessListener {

            }
        }

    }

    override fun getItemCount(): Int {

        return userlist.size
    }

    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val name : TextView = itemView.findViewById(R.id.getname)
        val phone : TextView = itemView.findViewById(R.id.getphone)
        val address : TextView = itemView.findViewById(R.id.getaddress)
        val employee : TextView = itemView.findViewById(R.id.getemployee)
        var status : TextView = itemView.findViewById(R.id.status)
        val approve : Button = itemView.findViewById(R.id.approve)
        val delete : Button = itemView.findViewById(R.id.delete)
    }
}