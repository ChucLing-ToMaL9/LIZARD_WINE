package com.example.lizardswine.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant{
    const val BASE_URL = "http://127.0.0.1/lizardwine_api/api/HoaDon/"
}

object HoaDonRetrofitClient{
    val hoaDonAPIService : HoaDonAPIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory
                .create(GsonBuilder().create()))
            .build()
            .create(HoaDonAPIService::class.java)
    }
}