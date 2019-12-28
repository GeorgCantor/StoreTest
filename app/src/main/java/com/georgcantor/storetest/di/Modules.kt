package com.georgcantor.storetest.di

import com.georgcantor.storetest.model.local.ProductsDatabase
import com.georgcantor.storetest.repository.ProductsRepository
import com.georgcantor.storetest.viewmodel.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductsRepository(get()) }
}

val viewModelModule = module {
    viewModel {
        StoreViewModel(get())
    }
}

val appModule = module {
    single { ProductsDatabase.buildDefault(get()).dao() }
}