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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CapNhatDiaChi(navHostController: NavHostController) {
    var fullname by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var selectedProvince by remember { mutableStateOf("") }
    var selectedDistrict by remember { mutableStateOf("") }
    var detailedAddress by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxWidth().navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            navHostController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Close",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        Text(
                            text = "Thêm địa chỉ",
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
        },
        bottomBar = {
            Column (modifier = Modifier.padding(vertical = 10.dp,horizontal = 10.dp)){
                androidx.compose.material.Button(
                    onClick = {
                        errorMessage = validateAddressInputs(
                            fullname,
                            phone,
                            selectedProvince,
                            selectedDistrict,
                            detailedAddress
                        )
                        if (errorMessage.isEmpty()) {
                            navHostController.navigate(Screen.DSDiaChi.route)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(
                        backgroundColor = Color(
                            0xFF188158
                        )
                    ),
                ) {
                    Text(
                        "Lưu địa chỉ",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(12.dp)
        ) {
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                Text(
                    "Số nhà",
                    fontSize = 14.sp,
                    color = Color(0xFF188158),
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = fullname,
                    onValueChange = { fullname = it },
                    placeholder = { Text("vd: 1027/ 26/ 17") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF188158),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                Text(
                    "Tên đường",
                    fontSize = 14.sp,
                    color = Color(0xFF188158),
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    placeholder = { Text("vd: Đường B7") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF188158),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                Text(
                    "Phường/ Xã/ Thị Trấn",
                    fontSize = 14.sp,
                    color = Color(0xFF188158),
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = detailedAddress,
                    onValueChange = { detailedAddress = it },
                    placeholder = { Text("vd: Phước Kiển") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF188158),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                Text(
                    "Huyện/Phường/Xã",
                    fontSize = 14.sp,
                    color = Color(0xFF188158),
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = detailedAddress,
                    onValueChange = { detailedAddress = it },
                    placeholder = { Text("vd: Nhà Bè") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF188158),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item {
                Text(
                    "Tỉnh/ Thành Phố",
                    fontSize = 14.sp,
                    color = Color(0xFF188158),
                    fontWeight = FontWeight.Bold
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
                OutlinedTextField(
                    value = detailedAddress,
                    onValueChange = { detailedAddress = it },
                    placeholder = { Text("vd: Hồ Chí Minh") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF188158),
                        unfocusedBorderColor = Color.Gray,
                    )
                )
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Text("")
                }
            }
        }
    }
}

// Hàm kiểm tra điều kiện đầu vào
fun validateAddressInputs(
    fullname: String,
    phone: String,
    province: String,
    district: String,
    detailedAddress: String
): String {
    val phoneRegex = Regex("^\\d{10,11}\$") // Số điện thoại phải có 10-11 chữ số

    return when {
        fullname.isBlank() -> "Họ và tên không được để trống"
        phone.isBlank() -> "Số điện thoại không được để trống"
        !phone.matches(phoneRegex) -> "Số điện thoại không hợp lệ"
        province.isBlank() -> "Chưa chọn tỉnh/thành phố"
        district.isBlank() -> "Chưa chọn quận/huyện"
        detailedAddress.isBlank() -> "Địa chỉ cụ thể không được để trống"
        else -> ""
    }
}
