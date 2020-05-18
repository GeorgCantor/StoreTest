package com.georgcantor.storetest

import android.app.Application
import com.georgcantor.storetest.di.apiModule
import com.georgcantor.storetest.di.repositoryModule
import com.georgcantor.storetest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(arrayListOf(apiModule, repositoryModule, viewModelModule))
        }
    }
}