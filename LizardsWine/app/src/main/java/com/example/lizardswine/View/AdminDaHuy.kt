package com.example.lizardswine.View

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.lizardswine.Model.ChiTietHoaDon
import com.example.lizardswine.Model.DS_AnhRuou
import com.example.lizardswine.Model.HoaDon
import com.example.lizardswine.Navigation.NavItem
import com.example.lizardswine.View.Custom_Compose.CardHoaDon

@Composable
fun DS_DaHuy(navHostController: NavHostController) {
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

    LazyColumn (
        modifier = Modifier.navigationBarsPadding()
    ){
        items(hoadons){
            CardHoaDon(
                hoadon = it,
                5,
                onClickCard = {
                    navHostController.navigate(NavItem.AdminChiTietDonHang.route)
                }
            )
        }
    }

}