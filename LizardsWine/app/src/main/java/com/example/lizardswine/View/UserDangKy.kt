package com.example.lizardswine.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DangKy(navHostController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    Scaffold (modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            navHostController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Close",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        Text(
                            text = "Đăng ký",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0A2E1F),
                    titleContentColor = Color.White
                )
            )
        }
    )
    {innerPadding ->

        LazyColumn (modifier = Modifier.padding(innerPadding).padding(12.dp).background(color = Color(0xFFE8F5E9)))
        {
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item { Text("Tên đăng nhập", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold) }
            item {Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = username,
                    onValueChange = { if (it.length <= 20) username = it },
                    placeholder = { Text("Tên đăng nhập (tối đa 20 ký tự)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {Text("Mật khẩu", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold) }
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Ít nhất 8 ký tự,chữ số và ký tự...") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp))}
            item {Text("Nhập lại mật khẩu", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold) }
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = { Text("Nhập lại mật khẩu") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp))}
            item {Text("Họ và tên", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold)}
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = fullname,
                    onValueChange = { fullname = it },
                    placeholder = { Text("Họ và tên của bạn") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {Spacer(modifier = Modifier.height(24.dp))}
            item {Text("Số điện thoại ", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold)}
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = { Text("Số điện thoại của bạn") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {Spacer(modifier = Modifier.height(24.dp))}
            item {Text("Email ", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold)}
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Email liên hệ") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp))}
            item {Text("Ngày sinh", fontSize = 14.sp, color = Color(0xFF188158), fontWeight = FontWeight.Bold)}
            item { Spacer(modifier = Modifier.height(8.dp))}
            item {
                OutlinedTextField(
                    value = birth,
                    onValueChange = { birth = it },
                    placeholder = { Text("Ngày sinh") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                // Thông báo lỗi
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                else {
                    Text("")
                }
            }
            item { Spacer(modifier = Modifier.height(12.dp))}
            item {
                Button(
                    onClick = {
                        errorMessage = validateInputs(username, fullname, password, confirmPassword, email, phone, birth)
                        navHostController.navigate(Screen.DangNhap.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = buttonColors(backgroundColor = Color(0xFF188158)),
                ) {
                    Text("Đăng ký", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
        }

    }
}


// Hàm kiểm tra điều kiện đầu vào
/*
    TenDangNhap varchar(50),
	MatKhau varchar(100),
	HoTen varchar(50),
	SoDienThoai char(11),
	Email varchar(50),
	NgaySinh date,
 */
fun validateInputs(
    username: String,
    fullname: String,
    password: String,
    confirmPassword: String,
    email: String,
    phone: String,
    birth: String
): String {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@(.+\\.com)$") // Email phải có đuôi .com
    val passwordRegex = Regex("^(?=.*[0-9])(?=.*[!@#\$%^&*])(?=.{8,})") // Mật khẩu phải có số và ký tự đặc biệt

    return when {
        username.isBlank() -> "Tên đăng nhập không được để trống"
        fullname.isBlank() -> "Họ và tên không được để trống"
        email.isBlank() -> "Email không được để trống"
        !email.matches(emailRegex) -> "Email không hợp lệ"
        password.isBlank() -> "Mật khẩu không được để trống"
        !password.matches(passwordRegex) -> "Mật khẩu phải có ít nhất 8 ký tự, chứa ít nhất một chữ số và một ký tự đặc biệt"
        password != confirmPassword -> "Mật khẩu và nhập lại mật khẩu không khớp"
        else -> ""
    }
}