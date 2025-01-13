package com.example.lizardswine.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lizardswine.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ThongTinNguoiDung() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TaiKhoan()
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004D40),
                    titleContentColor = Color.White
                )
            )

        },
        bottomBar = { BottomNavigationThongTin()}
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                DonHangSection()
                Spacer(modifier = Modifier.height(16.dp))
                NavigationItems()
            }
            item{
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                    androidx.compose.material3.Text(
                        text = "Một số sản phẩm khác",
                        color = Color(0xFF2C5F2D),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item{
                FlowRow(
                    modifier = Modifier.padding() .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center,
                    maxItemsInEachRow = 2
                ){
//                    ruouList.forEach{
//                            ruou -> WineItem(ruou)
//                    }
                }
            }
        }
    }
}

@Composable
fun TaiKhoan() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (   verticalAlignment = Alignment.CenterVertically,)
        {
            Image(
                painter = painterResource(id = R.drawable.anhuser),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Hải Trường",
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Text(
                    text = "(+84) 366 8686 ****",
                    style = TextStyle(fontSize = 14.sp),
                    color = Color.White
                )
            }
        }
        Row(   verticalAlignment = Alignment.CenterVertically,) {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = "Settings Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
                    .clickable { }
            )
            Icon(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart Icon",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
                    .clickable { }
            )
        }


    }
}
@Composable
fun DonHangSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFE8F5E9),
        elevation = 2.dp
    ) {
        Column {
            Text(
                "Đơn hàng",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp) // Giảm padding phía dưới
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(
                    Pair(R.drawable.wallet, "Chờ xác nhận"),
                    Pair(R.drawable.box, "Chờ lấy hàng"),
                    Pair(R.drawable.layhang, "Chờ giao hàng"),
                    Pair(R.drawable.danhgia, "Đánh giá")
                ).forEach { (iconId, label) ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable {},
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = iconId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .padding(8.dp),
                            tint = Color.Black
                        )
                        Text(
                            text = label,
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationItems() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        NavigationItem(iconId = R.drawable.vidientu, label = "Ví điện tử đã liên kết")
        Divider()
        NavigationItem(iconId = R.drawable.conversation, label = "Trung tâm trợ giúp")
        Divider()
        NavigationItem(iconId = R.drawable.question, label = "Trò chuyện với Lizard wine")
    }
}
@Composable
fun NavigationItem(iconId: Int, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            style = TextStyle(fontSize = 14.sp),
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun BottomNavigationThongTin() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF004D40)
    ) {
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.homeblack),
                contentDescription = "Home", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { androidx.compose.material.Text(text = "Trang chủ", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.history),
                contentDescription = "History", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { androidx.compose.material.Text(text = "Lịch sử", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.bell),
                contentDescription = "Bell", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { androidx.compose.material.Text(text = "Thông báo", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.userblack),
                contentDescription = "User", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { androidx.compose.material.Text(text = "Tài khoản", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
    }
}