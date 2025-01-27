package com.example.project1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: Adapter
    private val userList = mutableListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        val fabAddData: FloatingActionButton = findViewById(R.id.fab_add_data)

        // Initialize RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = Adapter(userList) { position -> deleteUser(position) }
        recyclerView.adapter = userAdapter

        // Handle Add Data Button Click
        fabAddData.setOnClickListener {
            addNewUser()
        }
    }

    private fun addNewUser() {
        // Example: Add a new user (You can replace this with a proper input screen or form)
        val newUser = UserData(
            name = "New User",
            mobile = "1234567890",
            email = "newuser@example.com",
            imageUri = null // Placeholder for image URI
        )
        userList.add(newUser)
        userAdapter.notifyItemInserted(userList.size - 1)
    }

    private fun deleteUser(position: Int) {
        userList.removeAt(position)
        userAdapter.notifyItemRemoved(position)
    }
}

