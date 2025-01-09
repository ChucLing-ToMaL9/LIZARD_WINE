package com.example.lizardwine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7)) // Màu nền chính
    ) {
        // Thanh tiêu đề
        TopAppBar(
            title = {
                Text(
                    text = "Giỏ hàng",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* TODO: Xử lý nút quay lại */ }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Quay lại")
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF1B5E20), // Màu nền tiêu đề
                titleContentColor = Color.White,    // Màu chữ tiêu đề
                navigationIconContentColor = Color.White // Màu biểu tượng quay lại
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Địa chỉ giao hàng
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ruou3), // Thay thế bằng icon địa chỉ của bạn
                contentDescription = "Địa chỉ",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Xã Phước Kiển, Huyện Nhà Bè, Hồ Chí Minh",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Danh sách sản phẩm trong giỏ hàng
        Column(modifier = Modifier.weight(1f)) {
            repeat(3) {
                CartItem(
                    name = "Vang Septima Obra Reserva Malbec",
                    price = "880.000 đ",
                    quantity = 1
                )
            }
        }

        // Phần gợi ý sản phẩm
        RecommendedSection()

        // Phần tổng tiền và nút mua hàng
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Tổng tiền:",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "880.000 đ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )
            Button(
                onClick = { /* TODO: Xử lý mua hàng */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Mua hàng (1)", color = Color.White)
            }
        }
    }
}

@Composable
fun CartItem(name: String, price: String, quantity: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { /* TODO: Xử lý chọn sản phẩm */ }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.wine1), // Thay thế bằng ảnh sản phẩm
            contentDescription = name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = price,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /* TODO: Giảm số lượng */ }) {
                Text(text = "-", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
            Text(text = quantity.toString(), fontSize = 16.sp, color = Color.Black)
            IconButton(onClick = { /* TODO: Tăng số lượng */ }) {
                Text(text = "+", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        ClickableText(
            text = AnnotatedString("Xóa"),
            onClick = { /* TODO: Xóa sản phẩm */ },
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 14.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun RecommendedSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Có thể bạn sẽ thích",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(3) {
                ProductCard(
                    name = "Vang Septima Obra Reserva Malbec",
                    price = "880.000 đ"
                )
            }
        }
    }
}

@Composable
fun ProductCard(name: String, price: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.wine2), // Thay thế bằng ảnh gợi ý
            contentDescription = name,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
        Text(
            text = price,
            fontSize = 12.sp,
            color = Color(0xFF1B5E20),
            fontWeight = FontWeight.Bold
        )
    }
}
