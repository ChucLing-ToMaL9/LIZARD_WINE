package com.example.lizardswine.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.lizardswine.Navigation.NavItem
import com.example.lizardswine.View.Custom_Compose.CardHoaDon
import com.example.lizardswine.ViewModel.HoaDonViewModel

@Composable
fun DS_DaDuyet(navHostController: NavHostController, viewModel: HoaDonViewModel = remember { HoaDonViewModel() }) {
    val hoaDonList = viewModel.hoaDonList.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val message = viewModel.message.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.layDSHoaDonTheoTrangThai(1)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when{
            isLoading.value -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color(0xFF0A2E1F)
                )
            }
            hoaDonList.value.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier.navigationBarsPadding()
                ) {
                    items(hoaDonList.value.size) { index ->
                        val hoadon = hoaDonList.value[index]
                        CardHoaDon(
                            navHostController,
                            hoadon = hoadon,
                            2,
                            onClickCard = {
                                navHostController.navigate(NavItem.AdminChiTietDonHang.route + "?MaHD=${hoadon.MaHD}")
                            },
                            viewModel
                        )

                    }
                }
            }
            message.value != null -> {
                Text(
                    text = (message.value + " Đã duyệt.") ?: " ",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else -> {
                Text(
                    text = "OMG! Api có vấn đề.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }
}