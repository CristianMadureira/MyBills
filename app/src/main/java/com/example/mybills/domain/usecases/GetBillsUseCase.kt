package com.example.mybills.domain.usecases

import com.example.mybills.domain.repository.BillRepository
import kotlinx.coroutines.flow.Flow

class GetBillsUseCase(private val repository: BillRepository) {
    operator fun invoke() = repository.getBills()
}