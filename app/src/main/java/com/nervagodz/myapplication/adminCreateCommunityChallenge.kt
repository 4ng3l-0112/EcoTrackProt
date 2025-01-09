package com.nervagodz.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity

class adminCreateCommunityChallenge: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_create_community_challenge)
    }
    fun createEvent(view: View) {
        Toast.makeText(this, "Challenge Has been Created", Toast.LENGTH_SHORT)
                .show()
        val intent = Intent(this, adminDashboard::class.java)
        startActivity(intent)
    }

    fun cancel(view: View) {
        Toast.makeText(this, "Challenge Creation Cancelled", Toast.LENGTH_SHORT)
                .show()
        val intent = Intent(this, adminDashboard::class.java)
        startActivity(intent)
    }
}