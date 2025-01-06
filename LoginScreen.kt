package com.example.myapplication







import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9)) // Màu nền xanh nhạt
            .padding(10.dp),
    ) {
        // Thanh tiêu đề
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1B5E20)) // Màu xanh đậm
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO: Thoát */ }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White
                )
            }
            Text(
                text = "Đăng nhập",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tên đăng nhập
        Text("Tên đăng nhập", fontSize = 14.sp, color = Color.Gray)
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Nhập tên đăng nhập") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Mật khẩu
        Text("Mật khẩu", fontSize = 14.sp, color = Color.Gray)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Nhập mật khẩu") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Nút đăng nhập
        Button(
            onClick = { /* TODO: Xử lý đăng nhập */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Đăng nhập", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Quên mật khẩu
        TextButton(onClick = { /* TODO: Xử lý quên mật khẩu */ }) {
            Text("Quên mật khẩu", color = Color.Gray, fontSize = 14.sp)
        }
    }
}
