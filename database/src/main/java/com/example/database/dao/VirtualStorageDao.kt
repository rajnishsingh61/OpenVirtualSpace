package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.database.entity.VirtualStorage
import kotlinx.coroutines.flow.Flow

@Dao
interface VirtualStorageDao {
    @Insert
    suspend fun insert(virtualStorage: VirtualStorage): Long

    @Update
    suspend fun update(virtualStorage: VirtualStorage)

    @Delete
    suspend fun delete(virtualStorage: VirtualStorage)

    @Query("SELECT * FROM virtual_storage WHERE id = :id")
    suspend fun getById(id: Int): VirtualStorage?

    @Query("SELECT * FROM virtual_storage WHERE cloneId = :cloneId ORDER BY virtualPath ASC")
    fun getStoragesByCloneId(cloneId: Int): Flow<List<VirtualStorage>>

    @Query("SELECT * FROM virtual_storage WHERE cloneId = :cloneId AND virtualPath = :virtualPath")
    suspend fun getStorageByPath(cloneId: Int, virtualPath: String): VirtualStorage?

    @Query("DELETE FROM virtual_storage WHERE cloneId = :cloneId")
    suspend fun deleteByCloneId(cloneId: Int)
}
