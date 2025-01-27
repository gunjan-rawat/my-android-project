package com.example.notes.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project1.Database.DataDao
import com.example.project1.Model.Data

@Database(entities = [Data::class], version = 2,exportSchema = false)
abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDao(): DataDao


    companion object {
        private const val DB_NAME = "Note_gunjan"

        @Volatile
        var INSTANCE: DataDatabase? = null
        fun getInstance(context: Context): DataDatabase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            DataDatabase::class.java,
                            DB_NAME
                        )
                            .build()
                }
                return INSTANCE
            }
        }
    }
}
