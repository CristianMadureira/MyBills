package com.example.mybills.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BillDao {

    @Insert
    suspend fun insertBill(bill: BillEntity)

    @Query("DELETE from bills WHERE id = :id ")
    suspend fun deleteBill(id: Long)

    @Query("SELECT * from bills ORDER BY name ASC")
    fun getAllBills(): Flow<List<BillEntity>>

}
