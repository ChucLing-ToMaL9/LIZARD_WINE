package com.example.lizardwine.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuaHoSo() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Hồ sơ của tôi", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { /* Quay lại trang cài đặt tài khoản */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF003D24))
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                Box(contentAlignment = Alignment.BottomCenter) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = "https://scontent.fsgn2-6.fna.fbcdn.net/v/t39.30808-6/456104924_1579424709303892_6615847918832495823_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=GD3FMXvpmAEQ7kNvgGDJYzk&_nc_oc=Adio4poLEKm3Ee4nHu3be6ldNhYplW592avegwwsSFwg58bK6OExqpjlW7igFJIhrFThPe_klwMWrGi9BLO4RZaD&_nc_zt=23&_nc_ht=scontent.fsgn2-6.fna&_nc_gid=A1ETGH1vawjj4apHfQs1oRL&oh=00_AYDQXsDWKWkrrQqUQrzikdqtIRZ0sci2Ylnxqh6bDthLZg&oe=6781473B" // Replace with your image URL or resource
                        ),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                    IconButton(
                        onClick = { /* đổi ảnh đại diện */ },
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_camera), // Replace with your camera icon
                            contentDescription = "Change Avatar",
                            tint = Color(0xFF004D40)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                ProfileInfoRow(title = "Tên người dùng", value = "Thi Nhân", isEditable = true)
                Spacer(modifier = Modifier.height(8.dp))
                ProfileInfoRow(title = "Điện thoại", value = "(+84) 333 8686 ****", isEditable = true)
                Spacer(modifier = Modifier.height(8.dp))
                ProfileInfoRow(title = "Email", value = "thinhan2004123@gmail.com", isEditable = true)
                Spacer(modifier = Modifier.height(8.dp))
                ProfileInfoRow(title = "Giới tính", value = "Nam", isEditable = true)
                Spacer(modifier = Modifier.height(8.dp))
                ProfileInfoRow(title = "Ngày sinh", value = "**/09/20**", isEditable = true)
            }
        }
    )
}

@Composable
fun ProfileInfoRow(title: String, value: String, isEditable: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp))
            .clickable(enabled = isEditable) { /* quay lại  */ }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
        if (isEditable) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Edit",
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
