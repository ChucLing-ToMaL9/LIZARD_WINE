package com.example.lizardswine.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lizardswine.Api.HoaDonAPIService
import com.example.lizardswine.Api.HoaDonRetrofitClient
import com.example.lizardswine.Model.HoaDon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HoaDonViewModel: ViewModel(){
    var dsHoaDonTheoTrangThai: List<HoaDon> by mutableStateOf(emptyList())

    fun layDSHoaDonTheoTrangThai(maTrangThai: Int){
        viewModelScope.launch(Dispatchers.IO){
            try{
                dsHoaDonTheoTrangThai = HoaDonRetrofitClient.hoaDonAPIService.layDSHoaDonTheoTrangThai(maTrangThai)
            }catch (e: Exception){
                Log.e("HoaDonViewModel", "Error getting hoadon", e)
            }
        }
    }
}