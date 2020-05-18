package com.georgcantor.storetest.di

import com.georgcantor.storetest.model.remote.ApiClient
import com.georgcantor.storetest.repository.ApiRepository
import com.georgcantor.storetest.view.fragment.CompaniesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {
    single { ApiClient.create(get()) }
}

val repositoryModule = module {
    single { ApiRepository(get()) }
}

val viewModelModule = module {
    viewModel {
        CompaniesViewModel(get())
    }
}