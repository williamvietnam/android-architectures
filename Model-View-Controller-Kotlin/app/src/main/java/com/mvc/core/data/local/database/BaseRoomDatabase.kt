package com.mvc.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvc.core.data.local.database.dao.UserDAO
import com.mvc.core.data.local.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class BaseRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}