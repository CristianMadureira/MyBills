package com.example.mybills.data

import com.example.mybills.data.db.BillDao
import com.example.mybills.data.db.BillEntity
import com.example.mybills.domain.repository.BillRepository
import kotlinx.coroutines.flow.Flow

class BillRepositoryImpl(private val dao: BillDao) : BillRepository {

    override fun getBills(): Flow<List<BillEntity>> =
        dao.getAllBills()

    override suspend fun addBill(bill: BillEntity) =
        dao.insertBill(bill = bill)


    override suspend fun deleteBill(bill: BillEntity) =
        dao.deleteBill(bill.id)


    override suspend fun paymentBill(bill: BillEntity) {
        TODO("Not yet implemented")
    }
}