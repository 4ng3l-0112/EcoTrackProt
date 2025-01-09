package com.nervagodz.myapplication.models

data class WasteRecord(
    val id: String,
    val userId: String,
    val wasteType: String,
    val quantity: Double,
    val unit: String,
    val timestamp: Long,
    var status: String = "pending" // "pending", "approved", "declined"
)
