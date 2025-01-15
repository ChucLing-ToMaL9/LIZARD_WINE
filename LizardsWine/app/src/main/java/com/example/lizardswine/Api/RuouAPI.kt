package com.example.lizardswine.Api

import com.example.lizardswine.Model.Ruou
import retrofit2.http.GET
import retrofit2.http.Query

data class RuouResponse(val ds_ruou: List<Ruou>)

interface RuouApi {
    @GET("ds_ruou.php")
    suspend fun getRuouList(@Query("MaR") maR: Int): RuouResponse
}