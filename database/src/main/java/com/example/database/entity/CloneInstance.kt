package com.example.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "clone_instance",
    foreignKeys = [
        ForeignKey(
            entity = AppInfo::class,
            parentColumns = ["id"],
            childColumns = ["appId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CloneInstance(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val appId: Int,
    val cloneNumber: Int,
    val dataPath: String,
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val lastAccessedAt: Long = System.currentTimeMillis()
)
