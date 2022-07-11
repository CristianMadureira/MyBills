package com.example.mybills.di

import com.example.mybills.domain.usecases.AddBillUseCase
import com.example.mybills.domain.usecases.DeleteBillUseCase
import com.example.mybills.domain.usecases.GetBillsUseCase
import com.example.mybills.domain.usecases.PaymentBillUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { AddBillUseCase(get()) }
    factory { DeleteBillUseCase(get()) }
    factory { GetBillsUseCase(get()) }
    factory { PaymentBillUseCase(get()) }

}