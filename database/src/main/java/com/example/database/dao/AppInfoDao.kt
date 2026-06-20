package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.entity.AppInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface AppInfoDao {
    @Insert
    suspend fun insert(appInfo: AppInfo): Long

    @Update
    suspend fun update(appInfo: AppInfo)

    @Delete
    suspend fun delete(appInfo: AppInfo)

    @Query("SELECT * FROM app_info WHERE id = :id")
    suspend fun getById(id: Int): AppInfo?

    @Query("SELECT * FROM app_info WHERE packageName = :packageName")
    suspend fun getByPackageName(packageName: String): AppInfo?

    @Query("SELECT * FROM app_info ORDER BY appName ASC")
    fun getAllApps(): Flow<List<AppInfo>>

    @Query("SELECT * FROM app_info WHERE isInstalled = 1 ORDER BY appName ASC")
    fun getInstalledApps(): Flow<List<AppInfo>>

    @Query("DELETE FROM app_info WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT COUNT(*) FROM app_info")
    suspend fun getCount(): Int
}
