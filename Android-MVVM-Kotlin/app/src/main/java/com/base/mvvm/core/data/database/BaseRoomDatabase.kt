package com.base.mvvm.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.base.mvvm.core.data.database.dao.UserDAO
import com.base.mvvm.core.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class BaseRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}