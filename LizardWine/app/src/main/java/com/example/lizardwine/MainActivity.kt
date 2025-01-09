package com.example.lizardwine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lizardwine.View.CaiDatTaiKhoan
import com.example.lizardwine.View.DoiMatKhau
import com.example.lizardwine.View.DonDaMua
import com.example.lizardwine.View.DanhGiaSanPham
import com.example.lizardwine.View.SuaHoSo
import com.example.lizardwine.View.SuaSoDienThoai
import com.example.lizardwine.View.SuaTen
import com.example.lizardwine.View.TaiKhoanBaoMat
import com.example.lizardwine.ui.theme.LizardWineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LizardWineTheme {
                //CaiDatTaiKhoan()
                //TaiKhoanBaoMat()
                //SuaTen()
                //SuaHoSo()
                //DoiMatKhau()
                //DonDaMua()
                //DanhGiaSanPham()
                SuaSoDienThoai()
            }
        }
    }
}

