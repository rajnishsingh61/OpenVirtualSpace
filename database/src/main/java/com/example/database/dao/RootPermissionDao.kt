package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.entity.RootPermission
import kotlinx.coroutines.flow.Flow

@Dao
interface RootPermissionDao {
    @Insert
    suspend fun insert(rootPermission: RootPermission): Long

    @Update
    suspend fun update(rootPermission: RootPermission)

    @Delete
    suspend fun delete(rootPermission: RootPermission)

    @Query("SELECT * FROM root_permission WHERE id = :id")
    suspend fun getById(id: Int): RootPermission?

    @Query("SELECT * FROM root_permission WHERE packageName = :packageName")
    suspend fun getByPackageName(packageName: String): RootPermission?

    @Query("SELECT * FROM root_permission ORDER BY packageName ASC")
    fun getAllPermissions(): Flow<List<RootPermission>>

    @Query("SELECT * FROM root_permission WHERE isGranted = 1 ORDER BY packageName ASC")
    fun getGrantedPermissions(): Flow<List<RootPermission>>

    @Query("SELECT * FROM root_permission WHERE isRemembered = 1 ORDER BY packageName ASC")
    fun getRememberedPermissions(): Flow<List<RootPermission>>

    @Query("UPDATE root_permission SET isGranted = :isGranted, isRemembered = :isRemembered, grantedAt = :grantedAt WHERE packageName = :packageName")
    suspend fun updatePermission(packageName: String, isGranted: Boolean, isRemembered: Boolean, grantedAt: Long)

    @Query("DELETE FROM root_permission WHERE packageName = :packageName")
    suspend fun deleteByPackageName(packageName: String)
}
