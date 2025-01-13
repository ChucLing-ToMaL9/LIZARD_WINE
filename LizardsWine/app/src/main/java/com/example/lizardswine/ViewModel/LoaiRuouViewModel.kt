package com.example.lizardswine.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lizardswine.Api.RuouRepository
import com.example.lizardswine.Model.HoaDon
import com.example.lizardswine.Model.LoaiRuou
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoaiRuouViewModel: ViewModel(){
    private val repository = RuouRepository()

    private val _ruouList = MutableStateFlow<List<LoaiRuou>>(emptyList())
    val ruouList: StateFlow<List<LoaiRuou>> get() = _ruouList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun fetchRuou() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _ruouList.value = repository.getRuou()
            } catch (e: Exception) {
            } finally {
                // Xử lý lỗi nếu cần
                _isLoading.value = false
            }
        }
    }

}