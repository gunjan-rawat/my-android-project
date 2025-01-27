package com.example.project1.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project1.Model.Data

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note : Data)

    @Delete
    fun delete(note : Data?)

    @Query("SELECT * FROM  data_table order by id ASC")
    fun getAllNotes(): List<Data>?

    @Query("UPDATE data_table set name=:name, mobile = :mobile, email = :email where id =:id")
    fun updateNote(id: Int? , name:String, mobile:String,email: String)



}