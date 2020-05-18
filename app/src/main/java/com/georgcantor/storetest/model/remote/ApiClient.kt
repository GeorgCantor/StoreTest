package com.georgcantor.storetest.model.remote

import android.content.Context
import com.georgcantor.storetest.BuildConfig
import com.georgcantor.storetest.model.remote.interceptor.OfflineResponseCacheInterceptor
import com.georgcantor.storetest.model.remote.interceptor.ResponseCacheInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object ApiClient {

    fun create(context: Context): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val okHttpClient = OkHttpClient().newBuilder()
            .addNetworkInterceptor(ResponseCacheInterceptor())
            .addInterceptor(OfflineResponseCacheInterceptor(context))
            .addInterceptor(loggingInterceptor)
            .cache(Cache(File(context.cacheDir, "ResponsesCache"), (10 * 1024 * 1024).toLong()))
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}