package com.example.lizardswine.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.lizardswine.R
import java.text.DecimalFormat
import com.example.lizardswine.Model.ChiTietSanPham

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ChiTietSanPham() {
    val chiTietRuou = (
            ChiTietSanPham(
                "",
                "Vang Septima Obra Reserva Malbec",
                100000000,
                "Việt nam",
                "Vang đen thui",
                13,
                750
            )
            )


    val listState = rememberLazyListState()
    val maxAlphaScroll = 300f // Khoảng cách cuộn tối đa để đạt alpha = 1

    val alpha by derivedStateOf {
        val scrollOffset = listState.firstVisibleItemScrollOffset.toFloat()
        if (scrollOffset >= maxAlphaScroll) {
            1f // Giữ alpha ở 1f khi cuộn vượt ngưỡng
        } else {
            (scrollOffset / maxAlphaScroll).coerceIn(0f, 1f)
        }
    }


    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF004D40))
                    //.navigationBarsPadding()
                    .padding(0.dp).padding(top = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RectangleShape, //Xóa border,
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = null,
                            tint = Color(0xFF004D40),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Thêm vào giỏ hàng", color = Color(0xFF004D40))
                    }
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF004D40)),
                    modifier = Modifier.weight(1f),
                    shape = RectangleShape,
                ) {
                    Text(text = "Mua ngay", color = Color.White)
                }
            }

        }
    ) { paddingValues ->
        var soLuongSP  by remember{ mutableStateOf(1) }
        val formatter = DecimalFormat("#,###")
        val giaBan = formatter.format(chiTietRuou.GiaBan)

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.anhchairuou),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .height(460.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = chiTietRuou.TenRuou,
                            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                            color = Color(0xFF0A2E1F)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                            Text(
                                text = "${giaBan} VND",
                                style = TextStyle(fontSize = 20.sp,  color = Color(0xFF0A2E1F))
                            )
                            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
                                Text ("5/5 ",  color = Color.Gray)
                                NgoiSao(soLuong = 5)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = " (200) | Đã bán 111",
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Gray
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row{
                                Icon(
                                    painter = painterResource(id = R.drawable.vietnam),
                                    contentDescription = null,
                                    tint = Color.Unspecified, // Vô hiệu hóa tint để giữ nguyên màu gốc
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = chiTietRuou.XuatXu, color = Color.Gray)
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_wine),
                                    contentDescription = null,
                                    tint = Color.Unspecified, // Vô hiệu hóa tint để giữ nguyên màu gốc
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = chiTietRuou.TenLoaiRuou, color = Color.Gray)
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Row{
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_wine_alcohol_degree),
                                    contentDescription = null,
                                    tint = Color.Unspecified, // Vô hiệu hóa tint để giữ nguyên màu gốc
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "${chiTietRuou.NongDoCon} %", color = Color.Gray)
                            }
                            Spacer(modifier = Modifier.width(6.dp))
                            Row{
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_wine_bottle_size),
                                    contentDescription = null,
                                    tint = Color.Unspecified, // Vô hiệu hóa tint để giữ nguyên màu gốc
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "${chiTietRuou.DungTich} ml", color = Color.Gray)
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "Mô tả:",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            color = Color(0xFF0A2E1F)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Ballantine's Christmas Reserve Quà tặng 2025 gây ấn" +
                                    " tượng với hương vị cân bằng hoàn hảo, kết hợp hương thơm ngọt ngào của" +
                                    " mật ong, cây trái như táo và lê, cùng chút cay nhẹ từ quế và gỗ. " +
                                    "Sắc vàng nhạt quyến rũ và hương thơm phong phú từ trái cây, bánh ngọt, " +
                                    "đến gỗ mang đến trải nghiệm tinh tế. Được pha trộn từ các loại whisky " +
                                    "thượng hạng từ Scotland, Ballantine's Finest là lựa chọn lý tưởng để " +
                                    "thưởng thức và chia sẻ trong dịp Tết.",
                            style = TextStyle(fontSize = 16.sp),
                            lineHeight = 20.sp,
                            color = Color(0xFF0A2E1F)
                        )
                    }
                }
                item {
                    Row (
                        modifier = Modifier.fillMaxWidth().padding(top = 0.dp).padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Text("Số lượng:", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0A2E1F))
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End){
                            IconButton(onClick = {
                                if(soLuongSP > 1) {
                                    soLuongSP--
                                }
                            }, modifier = Modifier.padding(horizontal = 20.dp)){
                                Icon(
                                    painter = painterResource(id = R.drawable.minus),
                                    contentDescription = null,
                                    tint = Color(0xFF0A2E1F)
                                )

                            }
                            Text(soLuongSP.toString(),  fontSize = 20.sp,  color = Color(0xFF0A2E1F))
                            IconButton(onClick = {
                                if(soLuongSP >= 1 ) {
                                    soLuongSP++
                                }
                            }, modifier = Modifier.padding(start = 20.dp)){
                                Icon(
                                    painter = painterResource(id = R.drawable.add),
                                    contentDescription = null,
                                    tint = Color(0xFF0A2E1F)
                                )
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "ĐÁNH GIÁ SẢN PHẨM", fontWeight = FontWeight.Bold, fontSize = 22.sp,
                            color = Color(0xFF0A2E1F),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            NgoiSao(soLuong = 5)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "5/5 (200 bài đánh giá)",
                                style = MaterialTheme.typography.body2,
                                color = Color.Gray
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.anhuser),
                                contentDescription = "User Avatar",
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Chai đẹp",fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0A2E1F)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    NgoiSao(soLuong = 5)
                                }
                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "Sản phẩm tốt, dùng rất ok, giao hàng cũng khá nhanh mọi người nên dùng thử nha :3",
                                    style = MaterialTheme.typography.body2,
                                    color = Color.Gray
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    repeat(3) {
                                        Image(
                                            painter = painterResource(id = R.drawable.anhchairuou),
                                            contentDescription = "Product Image",
                                            modifier = Modifier
                                                .size(60.dp)
                                                .clip(RoundedCornerShape(4.dp))
                                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                                        )
                                    }
                                }
                            }
                        }

                        Text(
                            text = "Xem tất cả >>",fontWeight = FontWeight.Bold,
                            color = Color(0xFF0A2E1F),
                            modifier = Modifier.align(Alignment.End).clickable(onClick = {})
                        )
                    }
                }
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(8.dp)
                    ) {
                        Divider(
                            color = Color(0xFF0A2E1F),
                            thickness = 1.dp,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "Một số sản phẩm khác",color = Color(0xFF0A2E1F), fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Divider(
                            color = Color(0xFF0A2E1F),
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
//                        dsRuou.forEach{
//                                ruou -> WineItem(ruou)
//                        }
                    }
                }
            }
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f), // Đặt TopAppBar lên trên
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    Color(0xFF0A2E1F).copy(alpha = 0.3f),
                                    shape = CircleShape
                                )
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.arrow),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Row(modifier = Modifier.padding(10.dp)) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        Color(0xFF0A2E1F).copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Spacer(modifier = Modifier.padding(10.dp))
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        Color(0xFF0A2E1F).copy(alpha = 0.3f),
                                        shape = CircleShape
                                    )
                                    .padding(10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cart),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004D40).copy(alpha = alpha),
                    titleContentColor = Color.White
                )
            )
        }
    }
}

@Composable
fun NgoiSao(soLuong: Int) {
    Row {
        repeat(soLuong) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}
