package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9)) // Nền xanh nhạt
            .padding(16.dp)
    ) {
        // Hiển thị danh sách 2 sản phẩm
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Chiếm phần lớn chiều cao màn hình
            verticalArrangement = Arrangement.spacedBy(16.dp) // Khoảng cách giữa 2 sản phẩm
        ) {
            ProductItem(
                imageRes = R.drawable.ruoue1, // Thay bằng resource hình ảnh chai rượu
                country = "Ý",
                name = "Vang F Gold Limited Edition",
                price = "888,000 VND",
                type = "Thùng bán hàng",
                volume = "Dung tích: 750ml",
                year = "2020"
            )
            ProductItem(
                imageRes = R.drawable.ruoue2, // Thay bằng resource hình ảnh chai rượu
                country = "Ý",
                name = "Vang Collefrisio Selezione",
                price = "999,000 VND",
                type = "Thùng bán hàng",
                volume = "Dung tích: 750ml",
                year = "2020"
            )
        }

        Spacer(modifier = Modifier.height(24.dp)) // Khoảng cách giữa phần trên và phần mô tả

        // Phần mô tả ở giữa
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Trải nghiệm hoàn hảo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20) // Màu xanh đậm
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Chúng tôi mang đến cho bạn những chai rượu vang thương hạng, "
                        + "đa dạng và các loại đồ uống tinh túy từ khắp nơi trên thế giới. "
                        + "Cam kết mức giá tốt nhất kèm theo thông tin minh bạch, giúp bạn an tâm lựa chọn và thưởng thức.",
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Khoảng cách trước phần nút

        // Nút Đăng nhập và Đăng ký
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp), // Căn lề nút hai bên
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* TODO: Xử lý đăng nhập */ },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Đăng nhập", color = Color.Black)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* TODO: Xử lý đăng ký */ },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Đăng ký", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Khoảng cách trước phần thông báo

        // Dòng "Tiếp tục với tài khoản khách"
        Text(
            text = "Tiếp tục với tài khoản khách",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ProductItem(
    imageRes: Int,
    country: String,
    name: String,
    price: String,
    type: String,
    volume: String,
    year: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp)) // Nền trắng và bo góc
            .height(120.dp) // Chiều cao của khung
    ) {
        // Hình ảnh chai rượu (nằm ngoài khung)
        Image(
            painter = painterResource(imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterEnd) // Căn hình ảnh về phía bên phải ngoài khung
                .offset(x = 16.dp), // Dịch ra khỏi khung thông tin
            contentScale = ContentScale.Fit
        )

        // Nội dung thông tin sản phẩm
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .align(Alignment.CenterStart) // Căn về phía trái khung
        ) {
            Text(text = "Quốc gia: $country", fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = price,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = type, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "$volume | $year", fontSize = 12.sp, color = Color.Gray)
        }
    }
}
