package com.example.lizardswine.View

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lizardswine.Api.RuouApi
import com.example.lizardswine.Model.Ruou
import com.example.lizardswine.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DecimalFormat

@Composable
fun DropMenu() {
    val menuItems = listOf(
        MenuItem("Rượu Vang", listOf("Rượu Vang Đỏ", "Rượu Vang Trắng", "Rượu Vang Hồng", "Rượu Vang Nổ Sparkling - \n" +
                "Champagne")),
        MenuItem("Rượu Mạnh", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
        MenuItem("Rượu Việt", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
        MenuItem("Thương Hiệu", listOf("Danh mục 2.1", "Danh mục 2.2", "Danh mục 2.3")),
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        menuItems.forEach { item ->
            DropdownMenuItemWithSubMenu(item)
        }
    }
}

@Composable
fun DropdownMenuItemWithSubMenu(menuItem: MenuItem) {
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
                color = Color.Black
            )
            if (menuItem.subMenu.isNotEmpty()) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }
        }
        AnimatedVisibility(visible = isExpanded) {Column(modifier = Modifier.padding(start = 16.dp)) {
            menuItem.subMenu.forEach { subItem ->
                Text(
                    text = subItem,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                        .padding(8.dp)
                )
            }
        }
        }
    }
}

data class MenuItem(
    val title: String,
    val subMenu: List<String> = emptyList()
)


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TrangChu(navHostController: NavHostController) {
    val api = remember {
        Retrofit.Builder()
            .baseUrl("https://93be-113-172-123-201.ngrok-free.app/lizardwine_api/api/Ruou/") // Địa chỉ IP local server
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RuouApi::class.java)
    }

    var ruouList by remember { mutableStateOf<List<Ruou>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    // Gọi API để lấy danh sách rượu
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val response = api.getRuouList(maR = 1)
                ruouList = response.ds_ruou
                Log.d("WineApp", "Dữ liệu nhận được: ${ruouList}")
            } catch (e: Exception) {
                ruouList = emptyList()
                Log.e("WineApp", "Lỗi khi gọi API", e)
            } finally {
                isLoading = false
            }
        }
    }

    val navdrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val configuration = LocalConfiguration.current;
    val screenWidth = configuration.screenWidthDp.dp//Tính kích thước màn hình

    ModalNavigationDrawer(
        modifier = Modifier.navigationBarsPadding(),
        drawerState = navdrawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(320.dp)
            ) {
                Row (
                    modifier = Modifier.width(320.dp)
                        .fillMaxWidth()
                        .background(color = Color(0xFF004D40))
                ){
                    Text(text = "DANH MỤC", modifier = Modifier.padding(25.dp).background(color = Color(0xFF004D40)), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White ))
                }
                HorizontalDivider()
                DropMenu()
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
                                    .background(Color.White, shape = RoundedCornerShape(24.dp))
                                    .padding(horizontal = 12.dp)
                                    .focusRequester(quanLiTrangThai)
                                    .onFocusChanged { trangThai = it.isFocused },
                                singleLine = true,
                                decorationBox = { innerTextField ->
                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween // Đặt icon ở cuối
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            if (!trangThai && inputText.isEmpty()) {
                                                Text(
                                                    text = "Nhập nội dung tìm kiếm...",
                                                    color = Color.Gray,
                                                    fontSize = 16.sp
                                                )
                                            }
                                            innerTextField()
                                        }
                                        IconButton(
                                            onClick = {},
                                            modifier = Modifier.padding(start = 41.dp) // Lùi icon sát mép ngoài hơn
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
                                    .clickable(onClick = {})
                            )
                        }

                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF004D40),
                        titleContentColor = Color.White
                    )
                )
            },
            bottomBar = { BottomNavigationBar() }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color(0xFFF5F5F5))
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.anhquanruou),
                        contentDescription = "Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "GỢI Ý HÔM NAY",
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 0.dp,
                                pressedElevation = 0.dp
                            )
                        ) {
                            Text("Xem tất cả >>")
                        }
                    }
                }
                item{
                    FlowRow(
                        modifier = Modifier.padding() .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalArrangement = Arrangement.Center,
                        maxItemsInEachRow = 2
                    ){
                        ruouList.forEach{
                                ruou -> WineItem(ruou)
                        }
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "RƯỢU VANG",
                            style = TextStyle(fontSize = 18.sp, color = Color.Black)
                        )
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            elevation = ButtonDefaults.elevation(
                                defaultElevation = 0.dp,
                                pressedElevation = 0.dp
                            )
                        ) {
                            Text("Xem tất cả >>")
                        }
                    }
                }
                item{
                    FlowRow(
                        modifier = Modifier.padding() .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalArrangement = Arrangement.Center,
                        maxItemsInEachRow = 2
                    ){
                        ruouList.forEach{
                                ruou -> WineItem(ruou)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WineItem(ruou: Ruou) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val formatter = DecimalFormat("#,###")
    val formattedGiaBan = ruou.GiaBan?.let { formatter.format(it.toDouble()) } ?: "N/A"

    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color(0xFFE8F5E9), shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.anhchairuou),
            contentDescription = "Wine Bottle",
            modifier = Modifier
                .size(screenWidth * 9 / 20)
                .padding(15.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = ruou.TenRuou ?: "Không tên",
            fontSize = 14.sp,
            color = Color.Black,
            maxLines = 2,
            textAlign = TextAlign.Center
        )

        Row (verticalAlignment = Alignment.CenterVertically){
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "$formattedGiaBan VND",
                fontSize = 14.sp,
                color = Color(0xFF004D40)
            )
            Spacer(modifier = Modifier.padding(18.dp))
            Text(
                text = "5",
                fontSize = 12.sp,
                color = Color(0xFF004D40)
            )
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(16.dp)
            )
        }

    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color(0xFF004D40),
        //modifier = Modifier.navigationBarsPadding()
    ) {
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.home),
                contentDescription = "Home", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Trang chủ", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.history),
                contentDescription = "History", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Lịch sử", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.bell),
                contentDescription = "Bell", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Thông báo", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painter = painterResource(id = R.drawable.user),
                contentDescription = "User", Modifier.size(25.dp).padding(bottom = 3.dp)) },
            label = { Text(text = "Tài khoản", style = TextStyle(fontSize = 13.sp)) },
            selected = true,
            onClick = {}
        )
    }
}