package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class residentDashboard: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resident_dashboard)
    }

    fun logWaste(view: View){
        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }

    fun communityChallenges(view: View){
        val intent = Intent(this,residentCommunityChallenges::class.java)
        startActivity(intent)
    }

    fun viewWasteHistory(view: View){
        val intent = Intent(this, residentViewWasteHistory::class.java)
        startActivity(intent)
    }

    fun goal(view: View){
        val intent = Intent(this, residentGoal::class.java)
        startActivity(intent)
    }

    fun tipsAndResources(view: View){
        val intent = Intent(this, residentTipsAndResources::class.java)
        startActivity(intent)
    }
}