package com.example.lizardswine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lizardswine.Navigation.NavGraph
import com.example.lizardswine.ViewModel.HoaDonViewModel
import com.example.lizardswine.ui.theme.LizardsWineTheme

class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    private val viewModel by viewModels<HoaDonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LizardsWineTheme {
                navHostController = rememberNavController()
                NavGraph(navHostController = navHostController, viewModel)
            }
        }
    }
}
