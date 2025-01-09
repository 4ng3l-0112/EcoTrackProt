package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class residentLogin:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resident_login)
    }

    fun LoginResident(view: View){
        val intent = Intent(this, residentDashboard::class.java)
        startActivity(intent)
    }
}