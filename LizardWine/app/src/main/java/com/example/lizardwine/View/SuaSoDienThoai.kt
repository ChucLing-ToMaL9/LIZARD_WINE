package com.example.lizardwine.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuaSoDienThoai() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sửa số điện thoại",
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
                    containerColor = Color(0xFF003D24) // Màu nền TopAppBar
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Biến lưu trạng thái và thông báo lỗi
            var phoneNumber by remember { mutableStateOf("") }
            var errorMessage by remember { mutableStateOf("") }

            // TextField: Nhập số điện thoại
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { input ->
                    phoneNumber = input
                    errorMessage = if (isValidVietnamesePhoneNumber(input)) {
                        ""
                    } else {
                        "Số điện thoại không hợp lệ. Phải có 10 chữ số và bắt đầu bằng 0."
                    }
                },
                label = { Text("Nhập số điện thoại") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFE8F5E9), // Nền xanh nhạt
                        shape = RoundedCornerShape(8.dp) // Bo góc
                    ),
                singleLine = true,
                trailingIcon = {
                    if (phoneNumber.isNotEmpty()) {
                        IconButton(onClick = { phoneNumber = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear",
                                tint = Color.Gray
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF003D24), // Màu viền khi focus
                    unfocusedBorderColor = Color.Gray, // Màu viền khi không focus
                    containerColor = Color.Transparent // Nền trong suốt
                )
            )

            // Hiển thị thông báo lỗi nếu có
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Đẩy nút xuống cuối màn hình

            // Button: Lưu số điện thoại
            Button(
                onClick = {
                    if (errorMessage.isEmpty()) {
                        // Xử lý lưu số điện thoại
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF003D24), // Màu xanh đậm
                    contentColor = Color.White // Màu chữ trắng
                ),
                shape = RoundedCornerShape(8.dp) // Bo góc
            ) {
                Text(
                    text = "Lưu",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Hàm kiểm tra số điện thoại Việt Nam
fun isValidVietnamesePhoneNumber(phone: String): Boolean {
    val regex = Regex("^0[0-9]{9}\$") // Bắt đầu bằng 0 và có 10 chữ số
    return regex.matches(phone)
}
