package com.example.lizardswine.Api

import com.example.lizardswine.Model.HoaDon
import retrofit2.http.GET
import retrofit2.http.Path

data class HoaDonResponse(
    val protocol: String,
    val code: String,
    var url: String
)

interface HoaDonAPIService{
//    @GET("music/")
//    suspend fun getAllMusic(): List<Music>

    @GET("ds_hoa_don_theo_tthd.php?MaTrangThai=1")
    suspend fun layDSHoaDonTheoTrangThai(
        @Path("MaTrangThai") hoadonMaTrangThai: Int
    ): List<HoaDon>

//    @POST("/music")
//    suspend fun addMusic(
//        @Body music: Music
//    ): Response<MusicResponse>
//
//    @PUT("/music/{id}")
//    suspend fun updateMusic(
//        @Path("id") musicId: String,
//        @Body music: Music
//    ): Response<MusicResponse>
//
//    @DELETE("/music/{id}")
//    suspend fun deleteMusic(
//        @Path("id") musicId: String
//    ): Response<MusicResponse>
}
