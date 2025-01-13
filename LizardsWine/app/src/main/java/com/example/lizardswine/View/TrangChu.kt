package com.example.lizardswine.View

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lizardswine.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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
        AnimatedVisibility(visible = isExpanded) {
            Column(modifier = Modifier.padding(start = 16.dp)) {
            menuItem.subMenu.forEach { subItem ->
                Text(
                    text = subItem,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Handle sub-menu item click */ }
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WineAppScreen() {
    val navdrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
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
                    navigationIcon = {
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

                    },
                    title = {
                        BasicTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(1f)
                                //.weight(1f)
                                .background(Color.White, shape = RoundedCornerShape(20.dp))
                                .padding(horizontal = 10.dp, vertical = 8.dp),
                            singleLine = true,
                            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                        )
                    },
                    actions = {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = "Cart",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                                .clickable(onClick = {})
                        )
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


                items(6) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        WineItem()
                        WineItem()
                    }
                }
                // }
            }
        }
    }
}


@Composable
fun SearchBar(scope: CoroutineScope, navdrawerState: DrawerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF004D40))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
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
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .padding(horizontal = 10.dp, vertical = 8.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = "Cart",
            tint = Color.White,
            modifier = Modifier.size(32.dp)
                .clickable(onClick = {})
        )
    }
}

@Composable
fun WineItem() {
    Column(
        modifier = Modifier
            .width(190.dp)
            .padding(8.dp)
            .background(Color(0xFFE8F5E9), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.anhchairuou),
            contentDescription = "Wine Bottle",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Vang Septima Obra Reserva Malbec",
            fontSize = 14.sp,
            color = Color.Black,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "880.000 đ",
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
        contentColor = Color(0xFF004D40)
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