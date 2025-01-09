package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class adminLogin: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_login)
    }

    fun adminDashboard(view: View){
        val intent = Intent(this, adminDashboard::class.java)
        startActivity(intent)
    }
}


