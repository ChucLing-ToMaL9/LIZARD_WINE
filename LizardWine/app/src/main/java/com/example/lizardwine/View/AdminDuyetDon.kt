package com.example.lizardwine.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lizardwine.R

@Composable
fun AdminWine() {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF009688)),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Duyệt đơn hàng",
                    color = Color.White,
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                )
            }
        },
        bottomBar = { BottomNavigationBarAdmin() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            OrderItem()
            Spacer(modifier = Modifier.height(5.dp))
            OrderItem()
        }
    }
}

@Composable
fun OrderItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFE8F5E9), // Màu nền xanh nhạt
        elevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.anhquanruou),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(70.dp) // Kích thước hình ảnh nhỏ hơn
                        .padding(end = 16.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Ballantine's Reserve",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Việt Nam",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                    )
                    Text(
                        text = "x2",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                    )
                    Text(
                        text = "900.000đ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
                Text(
                    text = "Thành tiền: 1.800.000đ",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B5E20) // Màu xanh đậm
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Xử lý Hủy đơn hàng */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFFF5252)), // Viền đỏ
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Hủy đơn hàng", color = Color(0xFFFF5252))
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Xử lý Duyệt đơn hàng */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFF009688)), // Viền xanh
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Duyệt đơn hàng", color = Color(0xFF009688))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBarAdmin() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF004D40)
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.booking),
                    contentDescription = "Home",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text(text = "Chờ duyệt", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.approval),
                    contentDescription = "History",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text(text = "Đã duyệt", style = TextStyle(fontSize = 13.sp)) },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.deliveryblack),
                    contentDescription = "Delivery",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text(text = "Đang giao", style = TextStyle(fontSize = 13.sp)) },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.cancel),
                    contentDescription = "Cancel",
                    modifier = Modifier.size(25.dp)
                )
            },
            label = { Text(text = "Đã hủy", style = TextStyle(fontSize = 13.sp)) },
            selected = false,
            onClick = {}
        )
    }
}
