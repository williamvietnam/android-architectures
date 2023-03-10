package com.mvc.core.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mvc.core.data.local.database.entities.UserEntity

@Dao
interface UserDAO: BaseDAO<UserEntity> {

    @Query("SELECT * FROM userEntity")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertAll(vararg userEntities: UserEntity)

    @Delete
    override fun delete(obj: UserEntity)

}