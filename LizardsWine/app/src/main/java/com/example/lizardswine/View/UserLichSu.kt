package com.example.lizardswine.View

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lizardswine.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LichSuMuaHang() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row (modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center)
                    {
                        Text("Lịch sử mua hàng", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                },
                actions = {
                    Row (modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center)
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Cart",
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                                .clickable(onClick = {})
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004D40),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = { BottomNavigationLichSu() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))
        ) {
            items(count = 10){
                Card()
            }
        }
    }

}
@Composable
fun Card(){
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
            },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFE8F5E9),
        elevation = 2.dp,

        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.anhchairuou),
                    contentDescription = "Product Image",
                    modifier = Modifier.size(100.dp)
                        .padding(8.dp),
                    tint = Color.Unspecified // Loại bỏ hiệu ứng màu
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
                Column(modifier = Modifier.padding(10.dp).padding(top = 72.dp),) {
                    Text(
                        text = "Thành tiền: 1.800.000đ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20)
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE8F5E9)),
                    border = BorderStroke(1.dp, Color.Gray),
                    //modifier = Modifier.weight(1.5f)
                ) {
                    Text(text = "Đánh giá", color = Color.Black)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE8F5E9)),
                    border = BorderStroke(1.dp, Color.Gray),
                    //modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Mua lại", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun BottomNavigationLichSu() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF004D40)
    ) {
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.homeblack),
                contentDescription = "Home", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Trang chủ", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.historyblack),
                contentDescription = "History", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Lịch sử", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.bell),
                contentDescription = "Bell", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Thông báo", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.user),
                contentDescription = "User", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Tài khoản", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
    }
}