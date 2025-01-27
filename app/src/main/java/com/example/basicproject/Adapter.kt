package com.example.project1

import com.example.project1.UserData


import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicproject.R

class Adapter(private val userList: MutableList<UserData>, private val onDelete: (Int) -> Unit) :
    RecyclerView.Adapter<Adapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgUser: ImageView = itemView.findViewById(R.id.img_user)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvMobile: TextView = itemView.findViewById(R.id.tv_mobile)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        val btnDelete: Button = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.tvName.text = user.name
        holder.tvMobile.text = user.mobile
        holder.tvEmail.text = user.email
        holder.imgUser.setImageURI(user.imageUri)

        holder.btnDelete.setOnClickListener {
            onDelete(position) // Call delete callback
        }
    }

    override fun getItemCount(): Int = userList.size
}
