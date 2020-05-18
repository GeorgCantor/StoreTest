package com.georgcantor.storetest.model.remote

import com.georgcantor.storetest.model.data.ApiResponse
import com.georgcantor.storetest.model.data.Company
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("test.php")
    suspend fun getCompanies(): MutableList<ApiResponse>

    @GET("test.php")
    suspend fun getCompany(@Query("id") id: String): MutableList<Company>
}