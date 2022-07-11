package com.example.mybills.domain.repository

import com.example.mybills.data.db.BillEntity
import kotlinx.coroutines.flow.Flow

interface BillRepository {
    fun getBills(): Flow<List<BillEntity>>
    suspend fun addBill(bill: BillEntity)
    suspend fun deleteBill(bill: BillEntity)
    suspend fun paymentBill(bill: BillEntity)
}