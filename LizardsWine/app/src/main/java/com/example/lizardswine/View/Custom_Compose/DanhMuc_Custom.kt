package com.example.lizardswine.View.Custom_Compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Model.DanhMucRuou
import com.example.lizardswine.Navigation.Screen

@Composable
fun DanhMucRuou(navHostController: NavHostController) {
    val danhMuc = listOf(
        DanhMucRuou("Rượu Vang", listOf("Rượu Vang Đỏ", "Rượu Vang Trắng", "Rượu Vang Hồng", "Rượu Vang Nổ Sparkling - \n" +
                "Champagne")),
        DanhMucRuou("Rượu Mạnh", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
        DanhMucRuou("Rượu Việt", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
        DanhMucRuou("Thương Hiệu", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        danhMuc.forEach { item ->
            ChiTietDanhMucRuou(item, navHostController)
        }
    }
}


@Composable
fun ChiTietDanhMucRuou(menuItem: DanhMucRuou, navHostController: NavHostController) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { if (menuItem.subMenu.isNotEmpty()) isExpanded = !isExpanded }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = menuItem.title,
                fontSize = 18.sp,
                color = Color(0xFF188158),
                fontWeight = FontWeight.ExtraBold
            )
            if (menuItem.subMenu.isNotEmpty()) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }
        AnimatedVisibility(visible = isExpanded) {
            Column(modifier = Modifier.padding(start = 16.dp)) {
            menuItem.subMenu.forEach { subItem ->
                Text(
                    text = subItem,
                    fontSize = 16.sp,
                    color = Color(0xFF188158),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navHostController.navigate(Screen.DSRuouTheoDanhMuc.route)
                        }
                        .padding(8.dp)
                )
            }
        }
        }
    }
}

