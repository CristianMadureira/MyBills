package com.example.mybills.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BillEntity::class], version = 1)
abstract class BillDatabase : RoomDatabase() {

    abstract val dao: BillDao

    companion object{

        private var INSTANCE: BillDatabase? = null

        fun getDatabase(context: Context): BillDatabase{
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BillDatabase::class.java,
                    "bills_database"
                )
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}