package com.example.lizardswine.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lizardswine.Model.Ruou
import com.example.lizardswine.Navigation.NavAppBar
import com.example.lizardswine.Navigation.NavGraphBar
import com.example.lizardswine.Navigation.Screen
import com.example.lizardswine.R
import com.example.lizardswine.View.Custom_Compose.CardDSRuouTheoDanhMuc
import com.example.lizardswine.View.Custom_Compose.CardRuou
import com.example.lizardswine.View.Custom_Compose.CardXemThem
import kotlinx.coroutines.launch
import com.example.lizardswine.View.Custom_Compose.DanhMucRuou
import com.example.lizardswine.ViewModel.RuouViewModel

@Composable
fun ManHinhChinh(navHostController: NavHostController){
    var navItemController = rememberNavController()
    Scaffold (
        bottomBar = {
            Column {
                NavAppBar(navHostController = navItemController)
            }
        }
    ){
        Box(modifier = Modifier.padding(it)){
            NavGraphBar(
                navHostController = navItemController,
                navRootController = navHostController
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TrangChu(navHostController: NavHostController, viewModel: RuouViewModel = viewModel()) {
    val scope = rememberCoroutineScope()



    LaunchedEffect(Unit) {
        viewModel.layDSRuouTheoMaLoaiR(9)
    }

    val dsRuouTheoMa9 = viewModel.ruouTheoMaList.collectAsState(initial = emptyList())  // Mã 9

    val navdrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val configuration = LocalConfiguration.current;
    val screenWidth = configuration.screenWidthDp.dp//Tính kích thước màn hình

    ModalNavigationDrawer(
        drawerState = navdrawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(320.dp),
                drawerContainerColor = Color(0xFFE8F5E9)
            ) {
                Row (
                    modifier = Modifier.width(320.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFF004D40))
                ){
                    Text(text = "DANH MỤC", modifier = Modifier.padding(25.dp), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White ))
                }
                HorizontalDivider()
                DanhMucRuou(navHostController, viewModel)
            }
        }
    ){

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(modifier = Modifier.fillMaxWidth().padding(0.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                            Icon(
                                painter = painterResource(id = R.drawable.hamburger),
                                contentDescription = "Menu",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clickable(onClick = {
                                        scope.launch {
                                            if (navdrawerState.isClosed) {
                                                navdrawerState.open()
                                            } else {
                                                navdrawerState.close()
                                            }
                                        }
                                    })
                            )
                            var inputText by remember { mutableStateOf("") }
                            var trangThai by remember { mutableStateOf(false) }
                            val quanLiTrangThai = remember { FocusRequester() }

                            BasicTextField(
                                value = inputText,
                                onValueChange = { inputText = it },
                                modifier = Modifier
                                    .width(screenWidth * 14 / 20)
                                    .height(40.dp)
                                    .background(Color.White, shape = RoundedCornerShape(5.dp))
                                    .padding(start = 12.dp)
                                    .focusRequester(quanLiTrangThai)
                                    .onFocusChanged { trangThai = it.isFocused },
                                singleLine = true,
                                decorationBox = { innerTextField ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween // Đặt icon ở cuối
                                    ) {

                                        if (!trangThai && inputText.isEmpty()) {
                                            Text(
                                                text = "Nhập nội dung tìm kiếm...",
                                                color = Color.Gray,
                                                fontSize = 16.sp
                                            )
                                        }
                                        innerTextField()

                                        IconButton(
                                            onClick = {} // Lùi icon sát mép ngoài hơn
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.search),
                                                contentDescription = "Search",
                                                tint = Color.Gray,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }
                                },
                                textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.cart),
                                contentDescription = "Cart",
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(end = 17.dp)
                                    .size(32.dp)
                                    .clickable(onClick = {navHostController.navigate(Screen.GioHang.route)})
                            )
                        }

                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF004D40),
                        titleContentColor = Color.White
                    )
                )
            }
        ) { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1), // Hiển thị cột
                modifier = Modifier.fillMaxSize().padding(paddingValues)
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.anhquanruou),
                        contentDescription = "Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                item {
                CardXemThem("RƯỢU VODKA"){
                    navHostController.navigate(Screen.DSRuouTheoDanhMuc.route + "?MaLoaiR=${9}&OtherParam=${"Rượu Vodka"}")
                }
                }
                item {
                CardDSRuouTheoDanhMuc(dsRuouTheoMa9,navHostController)
                }

            }
        }
    }
}
