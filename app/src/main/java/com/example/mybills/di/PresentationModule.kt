package com.example.mybills.di

import com.example.mybills.presentation.BillViewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory { BillViewModel(get(), get(), get(), get()) }
}