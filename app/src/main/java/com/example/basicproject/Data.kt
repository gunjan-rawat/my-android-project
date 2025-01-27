package com.example.project1.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
class Data (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,


    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "mobile")
    val mobile: String?,
    @ColumnInfo(name = "email")
    val email: String?
)
