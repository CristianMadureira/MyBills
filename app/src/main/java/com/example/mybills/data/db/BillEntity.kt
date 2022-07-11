package com.example.mybills.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.*

@Entity(tableName = "bills")
data class BillEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String = "",
    val dueDate: String = "",
    val value: Double = 0.0,
    val payment: Boolean = false
)
