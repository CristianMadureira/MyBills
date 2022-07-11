package com.example.mybills.di

import com.example.mybills.data.BillRepositoryImpl
import com.example.mybills.data.db.BillDatabase
import com.example.mybills.domain.repository.BillRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single<BillRepository> { BillRepositoryImpl(get()) }
}

val daoModule = module {

    single { BillDatabase.getDatabase(androidContext()).dao }
}