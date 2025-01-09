package com.nervagodz.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.nervagodz.myapplication.models.WasteRecord

class adminWasteRecords: ComponentActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var wasteRecordsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_waste_records)
        
        dbHelper = DatabaseHelper(this)
        wasteRecordsContainer = findViewById(R.id.wasteConf)
        
        loadPendingWasteRecords()
    }

    private fun loadPendingWasteRecords() {
        val records = dbHelper.getPendingWasteRecords()
        wasteRecordsContainer.removeAllViews()
        
        for (record in records) {
            displayWasteRecord(record)
        }
    }

    private fun displayWasteRecord(record: WasteRecord) {
        val recordView = layoutInflater.inflate(R.layout.waste_record_item, null)
        
        val titleView = recordView.findViewById<TextView>(R.id.title)
        val descView = recordView.findViewById<TextView>(R.id.dispoDesc)
        val acceptButton = recordView.findViewById<Button>(R.id.button16)
        val declineButton = recordView.findViewById<Button>(R.id.button17)

        titleView.text = "Waste Disposal - ${record.wasteType}"
        descView.text = "Quantity: ${record.quantity} ${record.unit}"

        acceptButton.setOnClickListener {
            dbHelper.updateWasteStatus(record.id.toLong(), "approved")
            loadPendingWasteRecords()
        }

        declineButton.setOnClickListener {
            dbHelper.updateWasteStatus(record.id.toLong(), "declined")
            loadPendingWasteRecords()
        }

        wasteRecordsContainer.addView(recordView)
    }
}