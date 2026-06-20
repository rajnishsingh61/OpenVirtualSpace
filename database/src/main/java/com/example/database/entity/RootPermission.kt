package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "root_permission")
data class RootPermission(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val packageName: String,
    val appName: String,
    val isGranted: Boolean = false,
    val isRemembered: Boolean = false,
    val grantedAt: Long = 0,
    val lastRequestAt: Long = System.currentTimeMillis()
)
