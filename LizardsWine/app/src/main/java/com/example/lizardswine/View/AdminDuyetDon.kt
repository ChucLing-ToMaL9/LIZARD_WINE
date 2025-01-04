package com.example.lizardswine.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Model.ChiTietHoaDon
import com.example.lizardswine.Model.DS_AnhRuou
import com.example.lizardswine.Model.HoaDon
import com.example.lizardswine.Navigation.NavItem
import com.example.lizardswine.View.Custom_Compose.CardHoaDon
import com.example.lizardswine.View.Custom_Compose.TabLayout
import com.example.lizardswine.ViewModel.HoaDonViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Admin_ManHinhChinh(navHostController: NavHostController, viewModel: HoaDonViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(top = 20.dp, end = 10.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Quản lí đơn hàng",
                        color = Color.White,
                        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF009688)
                )
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            TabLayout(navHostController, viewModel)
        }
    }
}



@Composable
fun DS_ChoXacNhan(navHostController: NavHostController, viewModel: HoaDonViewModel) {

    val hoadons = listOf<HoaDon>(
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        ),
        HoaDon(1, "user2", "0987654321", "789 Pham Hung Quan 3 Cau Giay Hanoi",
            listOf<ChiTietHoaDon>(
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Vivo Cabernet Sauvignon", 2, 700000,1400000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Septima Obra Reserva Malbec", 1, 600000,1200000),
                ChiTietHoaDon(listOf<DS_AnhRuou>(
                    DS_AnhRuou("https://bewinemart.ducanhzed.com/uploads/images/medium_images/Vang-Femar-Roma-rosso-DOC.jpg")
                ), "Rượu Vang Robert Mondavi Private Selection Cabernet Sauvignon", 1, 900000,1800000)
            ), "Thanh toán khi nhận hàn", "Chờ giao hàng", "Giảm giá theo hóa đơn", 15, "2025-01-06", 200000, 180000
        )
    )
    viewModel.layDSHoaDonTheoTrangThai(1)
    var ds_choxacnhan: List<HoaDon> = viewModel.dsHoaDonTheoTrangThai
    LazyColumn (
        modifier = Modifier.navigationBarsPadding()
    ){
        items(ds_choxacnhan){
            CardHoaDon(
                hoadon = it,
                1,
                onClickCard = {
                    navHostController.navigate(NavItem.AdminChiTietDonHang.route)
                }
            )
        }
    }

}
