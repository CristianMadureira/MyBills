package com.example.mybills

import android.app.Application
import com.example.mybills.di.daoModule
import com.example.mybills.di.dataModule
import com.example.mybills.di.domainModule
import com.example.mybills.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(
                domainModule,
                daoModule,
                dataModule,
                viewModelModule
            )
        }
    }
}