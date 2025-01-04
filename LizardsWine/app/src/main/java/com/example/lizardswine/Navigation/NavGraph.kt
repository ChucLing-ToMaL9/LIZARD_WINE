package com.example.lizardswine.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lizardswine.View.Admin_ManHinhChinh
import com.example.lizardswine.View.ChiTietDonHang
import com.example.lizardswine.View.DS_DaDuyet
import com.example.lizardswine.View.DS_DaGiao
import com.example.lizardswine.View.DS_DaHuy
import com.example.lizardswine.View.DS_DangGiao
import com.example.lizardswine.ViewModel.HoaDonViewModel

//Navigation Admin Screen
sealed class NavItem(val route: String) {
    data object AdminManHinhChinh : NavItem("admin_duyet_don_hang")
    data object AdminDaDuyet : NavItem("admin_xac_nhan_don_hang")
    data object AdminDangGiao : NavItem("admin_dang_giao_hang")
    data object AdminDaGiao : NavItem("admin_da_giao_hang")
    data object AdminHuyDon : NavItem("Admin_don_hang_huy")
    data object AdminChiTietDonHang : NavItem("admin_xem_chi_tiet_don_hang")
}


@Composable
fun NavGraph(navHostController: NavHostController, viewModel: HoaDonViewModel) {
    NavHost(
        navController = navHostController,
        startDestination = NavItem.AdminManHinhChinh.route
    ) {
        composable(NavItem.AdminManHinhChinh.route) {
            Admin_ManHinhChinh(navHostController, viewModel)
        }
        composable(NavItem.AdminDaDuyet.route) {
            DS_DaDuyet(navHostController)
        }
        composable(NavItem.AdminDangGiao.route) {
            DS_DangGiao(navHostController)
        }
        composable(NavItem.AdminDaGiao.route) {
            DS_DaGiao(navHostController)
        }
        composable(NavItem.AdminHuyDon.route) {
            DS_DaHuy(navHostController)
        }

        composable(NavItem.AdminChiTietDonHang.route) {
            ChiTietDonHang(navHostController)
        }
    }
}