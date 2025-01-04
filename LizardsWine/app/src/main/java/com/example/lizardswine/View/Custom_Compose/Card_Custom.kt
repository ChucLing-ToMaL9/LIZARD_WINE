package com.example.lizardswine.View.Custom_Compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lizardswine.Model.ChiTietHoaDon
import com.example.lizardswine.Model.HoaDon
import com.example.lizardswine.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardHoaDon(hoadon: HoaDon, manhinh: Int, onClickCard: () -> Unit){
    //1 -> duyệt
    //2 -> đã duyệt
    //3 -> đang giao
    //4 -> đã giao
    //5 -> đã hủy
    Card(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFE8F5E9),
        elevation = 2.dp,
        onClick = onClickCard
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            CardThongTinRuou(hoadon.ChiTietHoaDon[0])

            Text(
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                text = "Tổng số tiền (" + hoadon.TongThanhToan.toString() + " sản phẩm): " + hoadon.TongThanhToan.toString() + " VNĐ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F7D34)
                ),
                textAlign = TextAlign.Right
            )

            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                when(manhinh){
                    0 -> { }
                    1, 2 -> {
                        ButtonAccept_Cancel(
                            onClickButton = {},
                            colorText_Border = 0xFFFF5252,
                            text = "Hủy đơn hàng"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        ButtonAccept_Cancel(
                            onClickButton = {},
                            colorText_Border = 0xFF009688,
                            text = if(manhinh == 1) "Duyệt đơn hàng" else "Đã duyệt"
                        )
                    }
                    3 -> {
                        ButtonAccept_Cancel(
                            onClickButton = {},
                            colorText_Border = 0xFF009688,
                            text = "Đã giao hàng"
                        )
                    }
                    4 -> {
                        Text(
                            text = "Đơn hàng đã giao",
                            color = Color(0xFF009688)
                        )
                    }
                    5 -> {

                        Text(
                            text = "Lý do: ",
                            color = Color.Black
                        )
                        Text(
                            text = "Hết hàng",
                            color = Color(0xFF009688)
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun CardThongTinRuou(ruou: ChiTietHoaDon) {
    Row (
        modifier = Modifier.fillMaxWidth().height(100.dp)
    ){

        AsyncImage(
            model = ruou.DS_AnhRuou[0].AnhRuou,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )

        Column(
            modifier = Modifier.fillMaxHeight().padding(start = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = ruou.TenRuou,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0A2E1F)
                )
            )
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "x " + ruou.SoLuoong.toString(),
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                    textAlign = TextAlign.Right
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = ruou.DonGia.toString() + " VNĐ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0A2E1F)
                    ),
                    textAlign = TextAlign.Right
                )
            }

        }

    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardDiaChi(hoadon: HoaDon, onClickDiaChi: () -> Unit){
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFE8F5E9),
        shape = RoundedCornerShape(8.dp),
        onClick = onClickDiaChi
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "${hoadon.TenDangNhap} | ${hoadon.SoDT}", fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))
                Text(text = hoadon.DCGiaoHang)
            }
            Column(modifier = Modifier.padding(16.dp).padding(start = 10.dp)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "Arrow",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

    }
}

@Composable
fun CardPTThanhToan(hoadon: HoaDon){
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFE8F5E9),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Thanh toán", fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))

            Text(text = hoadon.LoaiThanhToan, fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))

        }
    }
}

@Composable
fun CardChiTietThanhToan(hoadon: HoaDon){
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color(0xFFE8F5E9),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Tổng tiền hàng", color = Color(0xFF0A2E1F))
                Text(text = "${hoadon.TongTien}", color = Color(0xFF0A2E1F))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Phí vận chuyển", color = Color(0xFF0A2E1F))
                Text(text = "20.000đ", color = Color(0xFF0A2E1F))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Giảm giá dành cho bạn", color = Color(0xFF0A2E1F))
                Text(text = "-50.000đ", color = Color.Red)
            }
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Tổng tiền sản phẩm", fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))
                Text(text = hoadon.TongThanhToan.toString(), fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))
            }
        }
    }
}