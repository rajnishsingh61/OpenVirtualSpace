package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.entity.DeviceProfile

@Dao
interface DeviceProfileDao {
    @Insert
    suspend fun insert(deviceProfile: DeviceProfile)

    @Update
    suspend fun update(deviceProfile: DeviceProfile)

    @Query("SELECT * FROM device_profile WHERE id = 1")
    suspend fun getProfile(): DeviceProfile?

    @Query("DELETE FROM device_profile")
    suspend fun deleteAll()
}
