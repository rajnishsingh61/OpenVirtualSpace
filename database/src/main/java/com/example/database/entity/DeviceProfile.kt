package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device_profile")
data class DeviceProfile(
    @PrimaryKey
    val id: Int = 1,
    val androidVersion: String = "",
    val buildNumber: String = "",
    val manufacturer: String = "",
    val model: String = "",
    val deviceId: String = "",
    val cpuAbi: String = "",
    val cpuAbi2: String = "",
    val cpuAbiList: String = "",
    val ramSize: Long = 0,
    val storageSize: Long = 0,
    val densityDpi: Int = 0
)
