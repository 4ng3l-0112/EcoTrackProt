package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class adminDashboard: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_dashboard)
    }

    fun adminWasteRecords(view: View){
        val intent = Intent(this, adminWasteRecords::class.java)
        startActivity(intent)
    }
    fun adminResidentRecords(view: View){
        val intent = Intent(this, adminResidentRecords::class.java)
        startActivity(intent)
    }
    fun adminCreateCommunityChallenge(view: View){
        val intent = Intent(this, adminCreateCommunityChallenge::class.java)
        startActivity(intent)
    }

}