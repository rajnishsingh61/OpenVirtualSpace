package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_info")
data class AppInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val packageName: String,
    val appName: String,
    val icon: ByteArray?,
    val isInstalled: Boolean = false,
    val installPath: String = "",
    val dataPath: String = "",
    val versionCode: Int = 0,
    val versionName: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AppInfo
        if (id != other.id) return false
        if (packageName != other.packageName) return false
        if (appName != other.appName) return false
        if (icon != null) {
            if (other.icon == null) return false
            if (!icon.contentEquals(other.icon)) return false
        } else if (other.icon != null) return false
        if (isInstalled != other.isInstalled) return false
        if (installPath != other.installPath) return false
        if (dataPath != other.dataPath) return false
        if (versionCode != other.versionCode) return false
        if (versionName != other.versionName) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + packageName.hashCode()
        result = 31 * result + appName.hashCode()
        result = 31 * result + (icon?.contentHashCode() ?: 0)
        result = 31 * result + isInstalled.hashCode()
        result = 31 * result + installPath.hashCode()
        result = 31 * result + dataPath.hashCode()
        result = 31 * result + versionCode
        result = 31 * result + versionName.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        return result
    }
}
