package com.example.mybills.domain.usecases

import com.example.mybills.data.db.BillEntity
import com.example.mybills.domain.repository.BillRepository

class AddBillUseCase(private val repository: BillRepository) {
    suspend operator fun invoke(bill: BillEntity) =
        repository.addBill(bill = bill)
}