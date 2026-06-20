package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.entity.CloneInstance
import kotlinx.coroutines.flow.Flow

@Dao
interface CloneInstanceDao {
    @Insert
    suspend fun insert(cloneInstance: CloneInstance): Long

    @Update
    suspend fun update(cloneInstance: CloneInstance)

    @Delete
    suspend fun delete(cloneInstance: CloneInstance)

    @Query("SELECT * FROM clone_instance WHERE id = :id")
    suspend fun getById(id: Int): CloneInstance?

    @Query("SELECT * FROM clone_instance WHERE appId = :appId ORDER BY cloneNumber ASC")
    fun getClonesByAppId(appId: Int): Flow<List<CloneInstance>>

    @Query("SELECT * FROM clone_instance WHERE appId = :appId AND cloneNumber = :cloneNumber")
    suspend fun getClone(appId: Int, cloneNumber: Int): CloneInstance?

    @Query("SELECT * FROM clone_instance WHERE isActive = 1 ORDER BY lastAccessedAt DESC")
    fun getActiveClones(): Flow<List<CloneInstance>>

    @Query("UPDATE clone_instance SET lastAccessedAt = :timestamp WHERE id = :id")
    suspend fun updateLastAccessedAt(id: Int, timestamp: Long)

    @Query("SELECT MAX(cloneNumber) FROM clone_instance WHERE appId = :appId")
    suspend fun getMaxCloneNumber(appId: Int): Int?

    @Query("DELETE FROM clone_instance WHERE id = :id")
    suspend fun deleteById(id: Int)
}
