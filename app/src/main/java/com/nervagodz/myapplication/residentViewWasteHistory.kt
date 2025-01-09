package com.nervagodz.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.nervagodz.myapplication.models.WasteRecord
import java.text.SimpleDateFormat
import java.util.*

class residentViewWasteHistory : ComponentActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var historyContainer: LinearLayout
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resident_view_waste_history)

        dbHelper = DatabaseHelper(this)
        historyContainer = findViewById(R.id.historyContainer)
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        loadWasteHistory()
    }

    private fun loadWasteHistory() {
        val userId = sharedPreferences.getString("userId", "") ?: return
        val records = dbHelper.getWasteRecords(userId)
        
        historyContainer.removeAllViews()
        for (record in records) {
            displayWasteRecord(record)
        }
    }

    private fun displayWasteRecord(record: WasteRecord) {
        val recordView = layoutInflater.inflate(R.layout.waste_history_item, null)
        
        val titleView = recordView.findViewById<TextView>(R.id.historyTitle)
        val descView = recordView.findViewById<TextView>(R.id.historyDesc)
        val statusView = recordView.findViewById<TextView>(R.id.historyStatus)
        val dateView = recordView.findViewById<TextView>(R.id.historyDate)

        val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
        val date = Date(record.timestamp)

        titleView.text = "Waste Disposal - ${record.wasteType}"
        descView.text = "Quantity: ${record.quantity} ${record.unit}"
        statusView.text = "Status: ${record.status.capitalize()}"
        dateView.text = dateFormat.format(date)

        historyContainer.addView(recordView)
    }
}