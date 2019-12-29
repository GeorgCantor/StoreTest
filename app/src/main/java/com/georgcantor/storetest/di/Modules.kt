package com.georgcantor.storetest.di

import com.georgcantor.storetest.model.local.ProductsDatabase
import com.georgcantor.storetest.repository.ProductsRepository
import com.georgcantor.storetest.viewmodel.BackViewModel
import com.georgcantor.storetest.viewmodel.ProductViewModel
import com.georgcantor.storetest.viewmodel.StoreViewModel
import com.georgcantor.storetest.viewmodel.UpdateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductsRepository(get()) }
}

val viewModelModule = module {
    viewModel {
        StoreViewModel(get())
    }
    viewModel {
        ProductViewModel(get())
    }
    viewModel {
        BackViewModel(get())
    }
    viewModel {
        UpdateViewModel(get())
    }
}

val appModule = module {
    single { ProductsDatabase.buildDefault(get()).dao() }
}