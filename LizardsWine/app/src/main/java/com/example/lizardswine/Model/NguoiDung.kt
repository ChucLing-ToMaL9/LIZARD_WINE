package com.example.lizardswine.Model

import java.util.Date

data class NguoiDung(
    val MaND: Int,
    val TenDangNhap: String,
    val AnhDaiDien: String?,
    val MatKhau: String,
    val HoTen: String,
    val SoDienThoai: Int,
    val Email: String,
    val NgaySinh: Date,
    val TrangThai: Boolean,
    val IsAdmin: Boolean
)



