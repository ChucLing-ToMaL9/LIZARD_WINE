package com.example.lizardswine.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lizardswine.View.CaiDatTaiKhoan
import com.example.lizardswine.View.CapNhatDiaChi
import com.example.lizardswine.View.ChiTietSanPham
import com.example.lizardswine.View.DSDiaChi
import com.example.lizardswine.View.DangKy
import com.example.lizardswine.View.DangNhap
import com.example.lizardswine.View.DanhGiaSanPham
import com.example.lizardswine.View.DanhSachDanhGia
import com.example.lizardswine.View.DoiMatKhau
import com.example.lizardswine.View.DonDaMua
import com.example.lizardswine.View.GioHang
import com.example.lizardswine.View.ManHinhChinh
import com.example.lizardswine.View.PhuongThucThanhToan
import com.example.lizardswine.View.SuaHoSo
import com.example.lizardswine.View.SuaSoDienThoai
import com.example.lizardswine.View.SuaTen
import com.example.lizardswine.View.TaiKhoanBaoMat
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
    data object TaiKhoanVaBaoMat: Screen("tai_khoan_va_bao_mat")
    data object DSDiaChi: Screen("danh_sach_dia_chi_nguoi_dung")
    data object ViDienTu: Screen("vi_dien_tu_da_lien_ket")
    data object HoSoNguoiDung: Screen("xem_ho_so")
    data object SuaSDT: Screen("cap_nhat_so_dien_thoai_nguoi_dung")
    data object SuaTen: Screen("cap_nhat_ten_nguoi_dung")
    data object SuaMatKhau: Screen("cap_nhat_mat_khau_nguoi_dung")
    data object DonDaMua: Screen("xem_don_hang_da_mua")
    data object CapNhatDiaChi: Screen("cap_nhat_dia_chi_nguoi_dung")
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
        composable(Screen.TaiKhoanVaBaoMat.route){
            TaiKhoanBaoMat(navHostController)
        }
        composable(Screen.DSDiaChi.route){
            DSDiaChi(navHostController)
        }
        composable(Screen.ViDienTu.route){
            PhuongThucThanhToan(navHostController)
        }
        composable(Screen.HoSoNguoiDung.route){
            SuaHoSo(navHostController)
        }
        composable(Screen.SuaSDT.route){
            SuaSoDienThoai(navHostController)
        }
        composable(Screen.SuaTen.route){
            SuaTen(navHostController)
        }
        composable(Screen.SuaMatKhau.route){
            DoiMatKhau(navHostController)
        }
        composable(Screen.DonDaMua.route){
            DonDaMua(navHostController)
        }
        composable(Screen.CapNhatDiaChi.route){
            CapNhatDiaChi(navHostController)
        }
    }
}
