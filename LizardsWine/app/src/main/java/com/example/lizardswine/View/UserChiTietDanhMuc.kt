package com.example.lizardswine.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Model.Ruou
import com.example.lizardswine.Navigation.Screen
import com.example.lizardswine.R
import com.example.lizardswine.View.Custom_Compose.CardDSRuouTheoDanhMuc
import com.example.lizardswine.View.Custom_Compose.CardRuou
import com.example.lizardswine.View.Custom_Compose.CardXemThem

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun XemChiTietDanhMucSP(navHostController: NavHostController){
    val dsRuou = listOf(
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1"),
        Ruou("1","1","ABC","1", emptyList(), "ABC",
            "VN", "750", "570", "1980", "con", "cay"
            ,"12000000", "21", "ngon", "1")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Tên danh mục",
                        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold),
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004D40)
                )
            )
        }

    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                FlowRow(
                    modifier = Modifier.padding() .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center,
                    maxItemsInEachRow = 2
                ){
                    dsRuou.forEach{
                        ruou -> CardRuou(ruou){
                            navHostController.navigate(Screen.ChiTietRuou.route)
                        }
                    }
                }
            }
        }

    }
}
