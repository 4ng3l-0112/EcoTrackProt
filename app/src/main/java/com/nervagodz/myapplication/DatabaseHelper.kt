package com.nervagodz.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.nervagodz.myapplication.models.WasteRecord

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "WasteDB"
        private const val DATABASE_VERSION = 1
        private const val TABLE_WASTE = "waste_records"
        
        private const val KEY_ID = "id"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_WASTE_TYPE = "waste_type"
        private const val KEY_QUANTITY = "quantity"
        private const val KEY_UNIT = "unit"
        private const val KEY_TIMESTAMP = "timestamp"
        private const val KEY_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """CREATE TABLE $TABLE_WASTE (
            $KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $KEY_USER_ID TEXT,
            $KEY_WASTE_TYPE TEXT,
            $KEY_QUANTITY REAL,
            $KEY_UNIT TEXT,
            $KEY_TIMESTAMP INTEGER,
            $KEY_STATUS TEXT)"""
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_WASTE")
        onCreate(db)
    }

    fun addWasteRecord(record: WasteRecord): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_USER_ID, record.userId)
            put(KEY_WASTE_TYPE, record.wasteType)
            put(KEY_QUANTITY, record.quantity)
            put(KEY_UNIT, record.unit)
            put(KEY_TIMESTAMP, record.timestamp)
            put(KEY_STATUS, record.status)
        }
        return db.insert(TABLE_WASTE, null, values)
    }

    fun updateWasteStatus(id: Long, status: String): Int {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_STATUS, status)
        }
        return db.update(TABLE_WASTE, values, "$KEY_ID = ?", arrayOf(id.toString()))
    }

    fun getWasteRecords(userId: String): List<WasteRecord> {
        val records = mutableListOf<WasteRecord>()
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_WASTE,
            null,
            "$KEY_USER_ID = ?",
            arrayOf(userId),
            null,
            null,
            "$KEY_TIMESTAMP DESC"
        )

        with(cursor) {
            while (moveToNext()) {
                val record = WasteRecord(
                    getString(getColumnIndexOrThrow(KEY_ID)),
                    getString(getColumnIndexOrThrow(KEY_USER_ID)),
                    getString(getColumnIndexOrThrow(KEY_WASTE_TYPE)),
                    getDouble(getColumnIndexOrThrow(KEY_QUANTITY)),
                    getString(getColumnIndexOrThrow(KEY_UNIT)),
                    getLong(getColumnIndexOrThrow(KEY_TIMESTAMP)),
                    getString(getColumnIndexOrThrow(KEY_STATUS))
                )
                records.add(record)
            }
        }
        cursor.close()
        return records
    }

    fun getPendingWasteRecords(): List<WasteRecord> {
        val records = mutableListOf<WasteRecord>()
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_WASTE,
            null,
            "$KEY_STATUS = ?",
            arrayOf("pending"),
            null,
            null,
            "$KEY_TIMESTAMP DESC"
        )

        with(cursor) {
            while (moveToNext()) {
                val record = WasteRecord(
                    getString(getColumnIndexOrThrow(KEY_ID)),
                    getString(getColumnIndexOrThrow(KEY_USER_ID)),
                    getString(getColumnIndexOrThrow(KEY_WASTE_TYPE)),
                    getDouble(getColumnIndexOrThrow(KEY_QUANTITY)),
                    getString(getColumnIndexOrThrow(KEY_UNIT)),
                    getLong(getColumnIndexOrThrow(KEY_TIMESTAMP)),
                    getString(getColumnIndexOrThrow(KEY_STATUS))
                )
                records.add(record)
            }
        }
        cursor.close()
        return records
    }
}
