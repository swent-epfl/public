package com.swent.mvvm.model.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

/** The database containing the characters.  */
@Database(entities = [CharacterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
