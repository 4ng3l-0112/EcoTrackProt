package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
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
import com.nervagodz.myapplication.ui.theme.EcoTrackProtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun adminLogin(view: View){
        val intent = Intent(this, adminLogin::class.java)
        startActivity(intent)
    }
    fun residentLogin(view: View){
        val intent = Intent(this, residentLogin::class.java)
        startActivity(intent)
    }
}



