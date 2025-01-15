package com.example.lizardswine.Model

data class Anh(val MaHA: String, val LinkAnh: String)

data class Ruou(
    val MaR: String,
    val MaLoaiR: String,
    val TenLoaiRuou: String,
    val MaHA: String,
    val AnhRuou: List<Anh>?,
    val TenRuou: String,
    val XuatXu: String,
    val NongDoCon: String,
    val DungTich: String,
    val NamSanXuat: String,
    val ThanhPhan: String,
    val HuongVi: String,
    val GiaBan: String,
    val SoLuongTon: String,
    val MoTa: String,
    val TrangThai: String
)