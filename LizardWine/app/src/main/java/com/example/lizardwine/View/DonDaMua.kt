package com.example.lizardwine.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lizardwine.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonDaMua() {
    val tabTitles = listOf("Chờ xác nhận", "Đã xác nhận", "Đang giao", "Đã giao")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Đơn đã mua",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Xử lý khi nhấn nút back */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF003D24) // Màu nền xanh
                )
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            // Tabs
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = Color(0xFF003D24), // Màu nền của TabRow
                contentColor = Color.White
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = title,
                                color = if (selectedTabIndex == index) Color.Red else Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }

            // Nội dung tab
            if (selectedTabIndex == 0) {
                // Chờ xác nhận
                ChoXacNhan()
            }
            else if(selectedTabIndex == 1)
            {
                DaXacNhan()
            }
            else if(selectedTabIndex == 2)
            {
                DangGiao()
            }
            else
            {
                DaGiao()
            }
        }
    }
}

@Composable
fun ChoXacNhan() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color(0xFFE8F5E9), // Nền xanh nhạt
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vang), // Thay bằng hình ảnh của sản phẩm
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Vang Septima Obra Reserva Malbec",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Việt Nam",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "900.000₫",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Text(
                text = "x2",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Thành tiền: 1.800.000₫",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedButton(
                onClick = { /* Xử lý hủy đơn hàng */ },
                border = BorderStroke(1.dp, Color.Red),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Red
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Hủy đơn hàng",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun DaXacNhan()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color(0xFFE8F5E9), // Nền xanh nhạt
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vang), // Thay bằng hình ảnh của sản phẩm
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Vang Septima Obra Reserva Malbec",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Việt Nam",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "900.000₫",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Text(
                text = "x2",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Thành tiền: 1.800.000₫",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedButton(
                onClick = { /* Xử lý hủy đơn hàng */ },
                border = BorderStroke(1.dp, Color.LightGray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = false
            ) {
                Text(
                    text = "Đã xác nhận",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun DangGiao()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color(0xFFE8F5E9), // Nền xanh nhạt
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vang), // Thay bằng hình ảnh của sản phẩm
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Vang Septima Obra Reserva Malbec",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Việt Nam",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "900.000₫",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Text(
                text = "x2",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Thành tiền: 1.800.000₫",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedButton(
                onClick = { /* Xử lý hủy đơn hàng */ },
                border = BorderStroke(1.dp, Color.LightGray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = false
            ) {
                Text(
                    text = "Đang giao",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun DaGiao()
{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color(0xFFE8F5E9), // Nền xanh nhạt
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.vang), // Thay bằng hình ảnh của sản phẩm
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Vang Septima Obra Reserva Malbec",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Việt Nam",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "900.000₫",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            Text(
                text = "x2",
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Thành tiền: 1.800.000₫",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            OutlinedButton(
                onClick = { /* Xử lý hủy đơn hàng */ },
                border = BorderStroke(1.dp, Color.LightGray),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.LightGray
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = false
            ) {
                Text(
                    text = "Đã giao",
                    fontSize = 14.sp
                )
            }
        }
    }
}
