package com.example.lizardswine.Api

import android.util.Log
import com.example.lizardswine.Model.HoaDon
import com.example.lizardswine.Model.LoaiRuou
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//ds_loai_ruou.php

interface ApiService {
    @GET("ds_loai_ruou.php") // Đường dẫn endpoint (sửa theo API của bạn)
    suspend fun getRuou(): List<LoaiRuou>
}
object RetrofitClient {
    private const val BASE_URL = "https://f9ea-2402-800-6346-d5b5-8d6c-3385-5849-e14.ngrok-free.app/lizardwine_api/api/" // Thay URL của bạn

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
class RuouRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getRuou(): List<LoaiRuou> {
        return apiService.getRuou()
    }
}