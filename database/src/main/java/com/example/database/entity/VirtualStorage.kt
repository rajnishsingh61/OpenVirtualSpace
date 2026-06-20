package com.example.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "virtual_storage",
    foreignKeys = [
        ForeignKey(
            entity = CloneInstance::class,
            parentColumns = ["id"],
            childColumns = ["cloneId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class VirtualStorage(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cloneId: Int,
    val hostPath: String,
    val virtualPath: String,
    val isReadOnly: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
