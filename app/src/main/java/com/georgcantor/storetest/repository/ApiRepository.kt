package com.georgcantor.storetest.repository

import com.georgcantor.storetest.model.remote.ApiService

class ApiRepository(private val apiService: ApiService) {

    suspend fun getCompanies() = apiService.getCompanies()

    suspend fun getCompany(id: Int) = apiService.getCompany(id)
}