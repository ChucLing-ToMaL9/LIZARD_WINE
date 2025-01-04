package com.example.lizardswine.Model

data class HoaDon (
    val MaHD: Int,
    val TenDangNhap: String,
    val SoDT: String,
    val DCGiaoHang: String,
    val ChiTietHoaDon: List<ChiTietHoaDon>,
    val LoaiThanhToan: String,
    val LoaiTrangThai: String,
    val LoaiKhuyenMai: String,
    val GiaTriKM: Int,
    val NgayLapHD: String,
    val TongTien: Int,
    val TongThanhToan: Int
)

data class ChiTietHoaDon(
    val DS_AnhRuou: List<DS_AnhRuou>,
    val TenRuou: String,
    val SoLuoong: Int,// SoLuong: Int
    val DonGia: Int,
    val ThanhTien: Int
)

data class DS_AnhRuou(
    val AnhRuou: String
)