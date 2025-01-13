package com.example.lizardswine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lizardswine.Navigation.AdminNavGraph
import com.example.lizardswine.Navigation.UserNavGraph
import com.example.lizardswine.ViewModel.HoaDonViewModel
import com.example.lizardswine.ui.theme.LizardsWineTheme

class MainActivity : ComponentActivity() {
    /* -- Admin
        private val viewModel by viewModels<HoaDonViewModel>()
        private lateinit var navHostController: NavHostController
     */

    //private val viewModel by viewModels<HoaDonViewModel>()
    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LizardsWineTheme {
                /* -- Admin
                    navHostController = rememberNavController()
                    AdminNavGraph(navHostController = navHostController, viewModel)
                 */

                navHostController = rememberNavController()
                UserNavGraph(navHostController = navHostController)
            }
        }
    }
}
