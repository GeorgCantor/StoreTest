package com.georgcantor.storetest.model.remote

import com.georgcantor.storetest.model.data.ApiResponse
import com.georgcantor.storetest.model.data.Company
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("test_task/test.php")
    suspend fun getCompanies(): ApiResponse

    @GET("test_task/test.php")
    suspend fun getCompany(@Query("id") id: Int): Company
}