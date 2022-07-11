package com.example.mybills.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybills.data.BillRepositoryImpl
import com.example.mybills.data.db.BillEntity
import com.example.mybills.domain.usecases.AddBillUseCase
import com.example.mybills.domain.usecases.DeleteBillUseCase
import com.example.mybills.domain.usecases.GetBillsUseCase
import com.example.mybills.domain.usecases.PaymentBillUseCase
import kotlinx.coroutines.launch
import java.util.*

class BillViewModel(
    private val addUseCase: AddBillUseCase,
    private val deleteUseCase: DeleteBillUseCase,
    private val getBillsUseCase: GetBillsUseCase,
    private val paymentUseCase: PaymentBillUseCase)
    : ViewModel() {

    val getListBills = getBillsUseCase()

    fun insertBill(bill: BillEntity) = viewModelScope.launch {
        addUseCase.invoke(bill = bill)
    }

    fun deleteBill(bill: BillEntity) = viewModelScope.launch {
        deleteUseCase.invoke(bill = bill)
    }

    fun paymmentBill(bill: BillEntity) = viewModelScope.launch {
        paymentUseCase.invoke(bill)
    }
    fun addNewInput(billName: String?, billDueDate: String?, billValue: String?) {
        viewModelScope.launch {
            val newBill = getNewInput(billName, billDueDate, billValue)
            insertBill(newBill)
        }
    }

    fun getNewInput(billName: String?, billDueDate: String?, billValue: String?,): BillEntity{
        return BillEntity( name = billName ?: "", dueDate = billDueDate ?: "", value = billValue?.toDouble() ?: 0.0)
    }



}