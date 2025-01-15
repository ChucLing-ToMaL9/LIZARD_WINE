package com.example.lizardswine.View

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Navigation.Screen
import com.example.lizardswine.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SuaHoSo(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sửa hồ sơ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFF003D24))
            )
        },
    ){innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {
                Image(
                    painter = painterResource(id = R.drawable.anhchairuou),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )
                IconButton(
                    onClick = {  },
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
            ProfileInfoRow(title = "Tên người dùng", value = "Thi Nhân", isEditable = true){
                navHostController.navigate(Screen.SuaTen.route)
            }
            Spacer(modifier = Modifier.height(8.dp))
            ProfileInfoRow(title = "Điện thoại", value = "(+84) 333 8686 ****", isEditable = true){
                navHostController.navigate(Screen.SuaSDT.route)
            }
            Spacer(modifier = Modifier.height(8.dp))
            ProfileInfoRow(title = "Email", value = "thinhan2004123@gmail.com", isEditable = true){}
            Spacer(modifier = Modifier.height(8.dp))
            ProfileInfoRow(title = "Mật khẩu", value = "******", isEditable = true){
                navHostController.navigate(Screen.SuaMatKhau.route)
            }
            Spacer(modifier = Modifier.height(8.dp))
            ProfileInfoRow(title = "Giới tính", value = "Nam", isEditable = true){}
            Spacer(modifier = Modifier.height(8.dp))
            ProfileInfoRow(title = "Ngày sinh", value = "**/09/20**", isEditable = true){}
        }
    }
}

@Composable
fun ProfileInfoRow(title: String, value: String, isEditable: Boolean, click: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp))
            .clickable(enabled = isEditable) { click() }
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
