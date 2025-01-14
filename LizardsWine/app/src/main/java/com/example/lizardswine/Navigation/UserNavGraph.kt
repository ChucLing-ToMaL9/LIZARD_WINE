package com.example.lizardswine.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lizardswine.View.CaiDatTaiKhoan
import com.example.lizardswine.View.ChiTietSanPham
import com.example.lizardswine.View.DangKy
import com.example.lizardswine.View.DangNhap
import com.example.lizardswine.View.DanhGiaSanPham
import com.example.lizardswine.View.DanhSachDanhGia
import com.example.lizardswine.View.GioHang
import com.example.lizardswine.View.ManHinhChinh
import com.example.lizardswine.View.ThanhToan
import com.example.lizardswine.View.TrangChu
import com.example.lizardswine.View.WelcomeToLizardWine
import com.example.lizardswine.View.XemChiTietDanhMucSP


//Navigation User Screen
sealed class Screen(val route: String){
    data object WelcomeToLizard: Screen("welcome_to_lizard")
    data object DangNhap: Screen("user_dang_nhap")
    data object DangKy: Screen("user_dang_ky")
    data object ManHinhChinh: Screen("man_hinh_chinh")
    data object GioHang: Screen("gio_hang")
    data object ChiTietRuou: Screen("chi_tiet_ruou")
    data object DSRuouTheoDanhMuc: Screen("danh_sach_ruou_theo_danh_muc")
    data object ThanhToan: Screen("thanh_toan")
    data object DSDanhGiaRuou: Screen("danh_sach_danh_gia_ruou")
    data object XemDSDanhGia: Screen("xem_danh_sach_danh_gia")
    data object CaiDat: Screen("cai_dat")
}

@Composable
fun UserNavGraph(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Screen.WelcomeToLizard.route
    ) {
        composable(Screen.WelcomeToLizard.route){
            WelcomeToLizardWine(navHostController)
        }
        composable(Screen.DangKy.route){
            DangKy(navHostController)
        }
        composable(Screen.DangNhap.route){
            DangNhap(navHostController)
        }
        composable(Screen.ManHinhChinh.route){
            ManHinhChinh(navHostController)
        }
        composable(Screen.GioHang.route){
            GioHang(navHostController)
        }
        composable(Screen.ChiTietRuou.route){
            ChiTietSanPham(navHostController)
        }
        composable(Screen.DSRuouTheoDanhMuc.route){
            XemChiTietDanhMucSP(navHostController)
        }
        composable(Screen.ThanhToan.route){
            ThanhToan(navHostController)
        }
        composable(Screen.DSDanhGiaRuou.route){
            DanhGiaSanPham(navHostController)
        }
        composable(Screen.XemDSDanhGia.route){
            DanhSachDanhGia(navHostController)
        }
        composable(Screen.CaiDat.route){
            CaiDatTaiKhoan(navHostController)
        }
    }
}
