package com.example.project1

import android.net.Uri

data class UserData(
    val name: String,
    val mobile: String,
    val email: String,
    val imageUri: Uri? = null // Optional image field
)
